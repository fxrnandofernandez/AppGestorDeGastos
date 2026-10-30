
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
    public void testConvertirACadenaBolivianos() {
        Dinero diezBolivianos = new Dinero("10.321");
        String resultado = diezBolivianos.convertirACadena();
        assertEquals("Bs 10.32", resultado);
    }

    @Test
    public void testConvertirUnNumeroEnteroAUnNumeroConDosDecimales(){
        Dinero cincoBolivianos = new Dinero("5");
        String resultado = cincoBolivianos.convertirACadena();
        assertEquals("Bs 5.00",resultado);
    }

     @Test
    public void testCadenaNoNumericaLanzaExcepcion() {
        try {
            new Dinero("dos"); 
            fail("Se esperaba NumberFormatException pero no se lanzó ninguna excepción.");
        } catch (NumberFormatException e) {
           
        }
    }
    
    @Test
    public void testMontoNegativoLanzaExcepcion() {      
        String montoNegativo = "-10.50";
        Exception excepcionCapturada = null;
        try {
            new Dinero(montoNegativo);
        } catch (IllegalArgumentException e) {
            excepcionCapturada = e; 
        }
        assertNotNull(excepcionCapturada, "Se esperaba IllegalArgumentException porque el dinero no puede ser negativo.");
    }
    
    
    @Test
    public void testRedondeoUltimoDecimalCincoOMayor(){
        String montoConTresDecimales = "10.555";
        Dinero montoARedondear = new Dinero(montoConTresDecimales);
        String resultado = montoARedondear.convertirACadena();
        assertEquals("Bs 10.56", resultado);
    }
    
    @Test
    public void testRedondeoUltimoDecimalCuatroOMenor(){
        String montoConTresDecimales = "10.554";
        Dinero montoARedondear = new Dinero(montoConTresDecimales);
        String resultado = montoARedondear.convertirACadena();
        assertEquals("Bs 10.55", resultado);
    }
    
}