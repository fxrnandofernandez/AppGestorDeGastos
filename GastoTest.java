
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class GastoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GastoTest
{
    /**
     * Default constructor for test class GastoTest
     */
    public GastoTest()
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
    public void TestObtenerInformacionDeUnGasto(){
        Dinero c1 = new Dinero("200");
        Gasto g1 = new Gasto(c1, "Compre un pantalon", 1);
        String res = g1.toString();
        assertEquals("Bs 200.00, Compre un pantalon, 1", res);
    }
    
    @Test
    public void conservaInformacionCompleta() {
        Gasto gasto = new Gasto(new Dinero("200"), "Pantalón", "02/11/2026", "Ropa", 7);
        assertEquals("Bs 200.00, Pantalón, 02/11/2026, Ropa, 7", gasto.obtenerInformacionCompleta());
        assertEquals("Bs 200.00, Pantalón, Ropa", gasto.toString());
        assertEquals("02/11/2026", gasto.getFechaDelGasto());
        assertEquals("Ropa", gasto.getCategoria());
        assertEquals("Pantalón", gasto.getDescripcion());
        assertEquals("Bs 200.00", gasto.getMonto().toString());
        assertEquals(7, gasto.getIdUsuario());
    }

    @Test
    public void identificaUsuariosPorSuId() {
        Gasto primero = new Gasto(new Dinero("1"), "Uno", 3);
        Gasto segundo = new Gasto(new Dinero("2"), "Dos", 3);
        Gasto tercero = new Gasto(new Dinero("3"), "Tres", 4);
        assertEquals(primero.getIdUsuario(), segundo.getIdUsuario());
        assertNotEquals(primero.getIdUsuario(), tercero.getIdUsuario());
    }
}