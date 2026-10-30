import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGestorUsuarios{
    public TestGestorUsuarios(){
    }
    
    @Test
    public void registrarUsuarioConNombreCorto(){
        GestorUsuario gestorDePrueba = new GestorUsuario();
        String nombre = "F";
        String correo = "fxrnandofernandez@gmail.com";
        String contrasenia = "contra123";

        assertThrows(
            IllegalArgumentException.class,
            () -> gestorDePrueba.registrarUsuario(nombre, correo, contrasenia)
        );
    }
    @Test
    public void registrarUsuarioConNombreCorrecto(){
        GestorUsuario gestorDePrueba = new GestorUsuario();
        String nombre = "Fernando";
        String correo = "fxrnandofernandez@gmail.com";
        String contrasenia = "contra123";
        Usuario resultado = gestorDePrueba.registrarUsuario(
                                    nombre,correo,contrasenia);
        assertNotNull(resultado);
    }
    
    @Test
    public void registrarUsuarioSinNombre(){
        GestorUsuario g = new GestorUsuario();
        String nombre = "";
        String correo = "fernando@gmail.com";
        String contrasenia = "contra123";
        
        assertThrows(
            IllegalArgumentException.class,
            () -> g.registrarUsuario(nombre, correo, contrasenia)
        );
    }
}