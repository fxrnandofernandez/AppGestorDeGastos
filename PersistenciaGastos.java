import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;

public class PersistenciaGastos
{   private Path archivo;

    public PersistenciaGastos(Path archivo) {
        this.archivo = archivo;
    }

    public void guardar(Gasto gasto) throws IOException {
        Files.writeString(
            archivo,
            gasto.obtenerInformacionCompleta() + System.lineSeparator(),
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
        );
    }

    public List<Gasto> cargar() throws IOException {
        List<Gasto> gastos = new ArrayList<>();

        List<String> lineas = Files.readAllLines(archivo);

        for (String linea : lineas) {
            String[] datos = linea.split(", ");

            Dinero monto = new Dinero(datos[0].replace("Bs ", ""));

            Gasto gasto = new Gasto(
                    monto,
                    datos[1],
                    datos[2],
                    datos[3],
                    Integer.parseInt(datos[4])
                );

            gastos.add(gasto);
        }

        return gastos;
    }
}