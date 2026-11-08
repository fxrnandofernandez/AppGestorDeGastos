

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The test class GestorDeUsuarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestGestorUsuario{
    @Test
    public void testRegistrarUsuarioSinNombre() {
        GestorUsuario gestor = new GestorUsuario();

        String nombre = "";
        String correo = "estudiante@gmail.com";
        String contrasenia = "contra123";

        IllegalArgumentException excepcion = assertThrows(
            IllegalArgumentException.class,
            () -> gestor.registrarUsuario(nombre, correo, contrasenia));
        assertEquals("El nombre no puede estar vacío",excepcion.getMessage());
    }

    @Test
    public void testRegistrarUsuarioConNombrePeroVacio() {
        GestorUsuario gestor = new GestorUsuario();

        String nombre = "    ";
        String correo = "estudiante@gmail.com";
        String contrasenia = "contra123";

        IllegalArgumentException excepcion = assertThrows(
            IllegalArgumentException.class,
            () -> gestor.registrarUsuario(nombre, correo, contrasenia));
        assertEquals("El nombre no puede estar vacío",excepcion.getMessage());
    }

    @Test
    public void testRegistrarUsuarioConNombreCorto(){
        GestorUsuario gestor = new GestorUsuario();
        String nombre = "F";
        String correo = "estudiante@gmail.com";
        String contrasenia = "contra123";

        IllegalArgumentException excepcion = assertThrows(
            IllegalArgumentException.class,
            () -> gestor.registrarUsuario(nombre, correo, contrasenia));
        assertEquals("Ingrese un nombre válido",excepcion.getMessage());
    }

    @Test
    public void testRegistrarUsuarioConCorreoVacio() {
        GestorUsuario gestor = new GestorUsuario();

        String nombre = "Alejandro";
        String correo = "";
        String contrasenia = "contra123";

        IllegalArgumentException excepcion = assertThrows(
            IllegalArgumentException.class,
            () -> gestor.registrarUsuario(nombre, correo, contrasenia));
        assertEquals("El correo no puede estar vacío",excepcion.getMessage());
    }

    @Test
    public void testRegistrarUsuarioConCorreoPeroVacio() {
        GestorUsuario gestor = new GestorUsuario();

        String nombre = "Alejandro";
        String correo = "      ";
        String contrasenia = "contra123";

        IllegalArgumentException excepcion = assertThrows(
            IllegalArgumentException.class,
            () -> gestor.registrarUsuario(nombre, correo, contrasenia));
        assertEquals("El correo no puede estar vacío",excepcion.getMessage());
    }

    @Test
    public void testRegistrarUsuarioConCorreoIncompletoSinArroba() {
        GestorUsuario gestor = new GestorUsuario();
        String nombre = "Alejandro";
        String correo = "Alejandrogmail.com";
        String contrasenia = "contra123";
        IllegalArgumentException excepcion = assertThrows(
            IllegalArgumentException.class,
            () -> gestor.registrarUsuario(nombre, correo, contrasenia));
        assertEquals("Ingrese un correo válido",excepcion.getMessage());
    }
    @Test
    public void testRegistrarUsuarioConCorreoIncompletoSinGmail() {
        GestorUsuario gestor = new GestorUsuario();
        String nombre = "Alejandro";
        String correo = "Alejandro@.com";
        String contrasenia = "contra123";
        IllegalArgumentException excepcion = assertThrows(
            IllegalArgumentException.class,
            () -> gestor.registrarUsuario(nombre, correo, contrasenia));
        assertEquals("Ingrese un correo válido",excepcion.getMessage());
    }
    @Test
    public void testRegistrarUsuarioConCorreoIncompletoSinPuntoCom() {
        GestorUsuario gestor = new GestorUsuario();
        String nombre = "Alejandro";
        String correo = "Alejandro@gmail";
        String contrasenia = "contra123";
        IllegalArgumentException excepcion = assertThrows(
            IllegalArgumentException.class,
            () -> gestor.registrarUsuario(nombre, correo, contrasenia));
        assertEquals("Ingrese un correo válido",excepcion.getMessage());
    }

    @Test
    public void testGuardarUsuarioEnArchivo() throws IOException {
        GestorUsuario gestor = new GestorUsuario();
        gestor.registrarUsuario(
            "Alejandro",
            "alejandro@gmail.com",
            "contra123"
        );
        File archivo = new File("usuarios.txt");

        assertTrue(archivo.exists());
    }

    @BeforeEach
    public void limpiarArchivo() throws IOException {
        Files.deleteIfExists(Path.of("usuarios.txt"));
    }

    @Test
    public void testGuardarDosUsuariosConIdDiferente() throws IOException {
        GestorUsuario gestor = new GestorUsuario();

        gestor.registrarUsuario(
            "Alejandro",
            "alejandro@gmail.com",
            "contra123"
        );

        gestor.registrarUsuario(
            "Carlos",
            "carlos@gmail.com",
            "contra456"
        );

        String contenido = Files.readString(
            Path.of("usuarios.txt")
        );

        assertTrue(contenido.contains("1,Alejandro"));
        assertTrue(contenido.contains("2,Carlos"));
    }

    @Test
    public void testRegistrarUsuarioConCorreoDuplicado() {
        GestorUsuario gestor = new GestorUsuario();
        gestor.registrarUsuario(
            "Alejandro",
            "alejandro@gmail.com",
            "contra123");
        IllegalArgumentException excepcion = assertThrows(
            IllegalArgumentException.class,
            () -> gestor.registrarUsuario(
                "Carlos",
                "alejandro@gmail.com",
                "contra456"));
        assertEquals(
            "Correo ya registrado",
            excepcion.getMessage());
    }

    @Test
    public void testRecuperarSiguienteIdDelArchivo() throws IOException {
        GestorUsuario gestor1 = new GestorUsuario();
        gestor1.registrarUsuario(
            "Alejandro",
            "alejandro@gmail.com",
            "contra123");
        // Simulamos reiniciar el gestor
        GestorUsuario gestor2 = new GestorUsuario();
        gestor2.registrarUsuario(
            "Carlos",
            "carlos@gmail.com",
            "contra456");
        String contenido = Files.readString(
            Path.of("usuarios.txt")
        );
        assertTrue(contenido.contains("1,Alejandro"));
        assertTrue(contenido.contains("2,Carlos"));
    }
    
}