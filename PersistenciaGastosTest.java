import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;

public class PersistenciaGastosTest
{
    private Path archivo;
    private PersistenciaGastos persistencia;
    private Gasto gasto;

    public PersistenciaGastosTest()
    {
    }

    @BeforeEach
    public void setUp() throws IOException
    {
        archivo = Path.of("gastos_test.txt");
        Files.deleteIfExists(archivo);
        persistencia = new PersistenciaGastos(archivo);
        Dinero monto = new Dinero("50");
        gasto = new Gasto(monto, "Almuerzo", "11/02/26", "Comida", 1);
    }

    @AfterEach
    public void tearDown() throws IOException
    {

    }

    @Test
    public void testGuardarUnGasto() throws IOException
    {
        persistencia.guardar(gasto);
        assertTrue(Files.exists(archivo));
    }

    @Test
    public void testGuardarDescripcionGasto() throws IOException
    {
        persistencia.guardar(gasto);
        String contenido = Files.readString(archivo);
        assertTrue(contenido.contains("Almuerzo"));
    }

    @Test
    public void testGuardarTodosLosDatosDelGasto() throws IOException
    {
        persistencia.guardar(gasto);

        String contenido = Files.readString(archivo);

        assertTrue(contenido.contains("50"));
        assertTrue(contenido.contains("Almuerzo"));
        assertTrue(contenido.contains("11/02/26"));
        assertTrue(contenido.contains("Comida"));
        assertTrue(contenido.contains("1"));
    }

    @Test
    public void testGuardarDosGastos() throws IOException
    {
        Gasto segundoGasto = new Gasto(
                new Dinero("30"),
                "Pasaje",
                "12/02/26",
                "Transporte",
                1
            );

        persistencia.guardar(gasto);
        persistencia.guardar(segundoGasto);

        String contenido = Files.readString(archivo);

        assertTrue(contenido.contains("Almuerzo"));
        assertTrue(contenido.contains("Pasaje"));
    }

    @Test
    public void testGuardarVariosGastos() throws IOException
    {
        Gasto segundoGasto = new Gasto(
                new Dinero("30"),
                "Pasaje",
                "12/02/26",
                "Transporte",
                1
            );

        Gasto tercerGasto = new Gasto(
                new Dinero("1200"),
                "Monitor Asus",
                "12/08/26",
                "Tecnologia",
                2
            );         
        Gasto cuartoGasto = new Gasto(
                new Dinero("500"),
                "Parlante JBL",
                "01/11/26",
                "Accesorios",
                2
            );
        persistencia.guardar(gasto);
        persistencia.guardar(segundoGasto);
        persistencia.guardar(tercerGasto);
        persistencia.guardar(cuartoGasto);

        String contenido = Files.readString(archivo);

        assertTrue(contenido.contains("Almuerzo"));
        assertTrue(contenido.contains("Pasaje"));
        assertTrue(contenido.contains("Monitor"));
        assertTrue(contenido.contains("Parlante"));
    }

    @Test
    public void testRecuperarVariosGastos() throws IOException
    {
        Gasto segundoGasto = new Gasto(
                new Dinero("30"),
                "Pasaje",
                "12/02/26",
                "Transporte",
                1
            );

        Gasto tercerGasto = new Gasto(
                new Dinero("30"),
                "Monitor Asus",
                "12/08/26",
                "Tecnologia",
                2
            );

        persistencia.guardar(gasto);
        persistencia.guardar(segundoGasto);
        persistencia.guardar(tercerGasto);

        List<Gasto> gastos = persistencia.cargar();

        assertEquals(3, gastos.size());

        assertEquals("Almuerzo", gastos.get(0).getDescripcion());
        assertEquals("Pasaje", gastos.get(1).getDescripcion());
        assertEquals("Monitor Asus", gastos.get(2).getDescripcion());
    }
}