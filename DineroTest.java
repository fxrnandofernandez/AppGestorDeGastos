
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DineroTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DineroTest
{
    /**
     * Default constructor for test class DineroTest
     */
    public DineroTest()
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
    public void testTextoCon3DecimalesLoReduceATextoCon2Decimales() {
        Dinero diezBolivianosCon32Centavos = new Dinero("10.321");
        String resultado = diezBolivianosCon32Centavos.toString();
        assertEquals("Bs 10.32", resultado);
    }

    @Test
    public void testTextoCon1DecimalLoExtiendeATextoCon2Decimales(){
        Dinero diezBolivianosCon30Centavos = new Dinero("10.3");
        String resultado = diezBolivianosCon30Centavos.toString();
        assertEquals("Bs 10.30", resultado);
    }
    
    @Test
    public void testTextoSinDecimalesLoExtiendeATextoCon2Decimales(){
        Dinero cincoBolivianos = new Dinero("5");
        String resultado = cincoBolivianos.toString();
        assertEquals("Bs 5.00", resultado);
    }
}