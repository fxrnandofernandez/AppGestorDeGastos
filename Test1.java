import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class Test1.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Test1
{
    /**
     * Default constructor for test class xd
     */
    public Test1()
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
    public void registrarGastoMayorACero(){
        Gasto gasto1 = new Gasto();
        int gastoRealizado  = 5;
        String resultado = gasto1.registrarGasto(gastoRealizado);
        assertEquals("Registro exitoso", resultado);
    }

    @Test
    public void registrarGastoNoPositivo(){
        Gasto gasto1 = new Gasto();
        int gastoRegistrado = -2;
        String resultado = gasto1.registrarGasto(gastoRegistrado);
        assertEquals("Cantidad no valida", resultado);
    }
    
    }