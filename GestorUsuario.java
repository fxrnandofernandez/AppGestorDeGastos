import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

public class GestorUsuario {
    private int siguienteId = 1;
    public void registrarUsuario(String nombre,String correo,
                                    String contrasenia) {        
        validarNombre(nombre);
        validarCorreo(correo);
        if (existeCorreo(correo)) {
            throw new IllegalArgumentException(
              "Correo ya registrado");
        }
        siguienteId = obtenerSiguienteId();
        Usuario usuario = crearUsuario(nombre, correo, contrasenia);
        guardarEnArchivo(convertirUsuarioEnRegistro(usuario));
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre no puede estar vacío");
        }
        if (nombre.length() <= 2 || nombre.length() >= 150) {
            throw new IllegalArgumentException(
                "Ingrese un nombre válido");
        }
    }

    private void validarCorreo(String correo) {
        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException(
                "El correo no puede estar vacío");
        }
        if (!correo.contains("@") ||
            !correo.contains(".com") ||
            !correo.contains("gmail")) {
            throw new IllegalArgumentException(
                "Ingrese un correo válido");
        }
    }

    private boolean existeCorreo(String correo) {
        List<String> registros = leerUsuarios();
        for (String registro : registros) {
            String[] datos = registro.split(",");
            if (datos.length >= 3 &&
                datos[2].equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }

    private List<String> leerUsuarios() {
        try {
            if (!Files.exists(Path.of("usuarios.txt"))) {
                return new ArrayList<>();
            }    
            return Files.readAllLines(Path.of("usuarios.txt"));
        } catch (IOException e) {
            throw new RuntimeException(
                "Error al leer usuarios", e);
        }
    }

    private int obtenerSiguienteId() {    
        int mayorId = 0;
        List<String> registros = leerUsuarios();
        for (String registro : registros) {
            String[] datos = registro.split(",");
            if (datos.length >= 3) {
                int id = Integer.parseInt(datos[0]);
                if (id > mayorId) {
                    mayorId = id;
                }
            }
        }
        return mayorId + 1;
    }

    private Usuario crearUsuario(String nombre, String correo,
                             String contrasenia) {
        Usuario usuario = new Usuario(siguienteId,nombre,
                        correo,contrasenia);    
        return usuario;
    }

    private void guardarEnArchivo(String registro) {
        try (FileWriter escritorUsuarios =
                 new FileWriter("usuarios.txt", true)) {
            escritorUsuarios.write(registro + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar usuario", e);
        }
    }

    private String convertirUsuarioEnRegistro(Usuario usuario) {
        return usuario.getID()+ "," + usuario.getNombre() + "," +
               usuario.getCorreo();
    }
    
    
}