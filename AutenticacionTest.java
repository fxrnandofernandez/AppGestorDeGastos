import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;

public class AutenticacionTest {
    private final String ARCHIVO = "usuariosPrueba.txt";

    @Before
    public void setUp() throws IOException {
        try (FileWriter fw = new FileWriter(ARCHIVO)) {
            fw.write("1,Alejandro,alejandro@gmail.com\n");
            fw.write("2,Carlos,carlos@gmail.com\n");
        }
    }

    @After
    public void tearDown() {
        new File(ARCHIVO).delete();
    }
    @Test
    public void loginCorrecto() {
    Usuario usuarioRegistrado = new Usuario(1, "Alejandro", "alejandro@gmail.com", "1234");
    assertTrue(Autenticacion.iniciarSesion(ARCHIVO, usuarioRegistrado));
    }   
    @Test
    public void loginCorreoIncorrecto() {
    Usuario usuarioPrueba = new Usuario(1, "Alejandro", "correo.falso@gmail.com","1234");
    assertFalse(Autenticacion.iniciarSesion(ARCHIVO, usuarioPrueba));

    }
    @Test
    public void loginUsuarioNoExiste() {
    Usuario usuarioPrueba = new Usuario(1, "UsuarioFalso", "alejandro@gmail.com", "1234");
    assertFalse(Autenticacion.iniciarSesion(ARCHIVO, usuarioPrueba));
    }
    @Test
    public void loginArchivoVacio() {
    Usuario usuarioPrueba = new Usuario(1, "Alejandro", "alejandro@gmail.com", "1234");
    assertFalse(Autenticacion.iniciarSesion("archivo_vacio.txt", usuarioPrueba));
}
}
