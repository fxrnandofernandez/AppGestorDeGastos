

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TestGestorUsuarios.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GestorUsuariosTest
{
    /**
     * Default constructor for test class TestGestorUsuarios
     */
    public GestorUsuariosTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void registrarUsuario(){
        GestorUsuarios g = new GestorUsuarios();
        String nombre = "Fernando";
        String correo = "fxrnandofernandez@gmail.com";
        String res = g.registrarUsuario(nombre, correo);
        assertEquals("Registro exitoso", res);
    }
}