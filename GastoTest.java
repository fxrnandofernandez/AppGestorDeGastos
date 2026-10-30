

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
        Dinero c1 = new Dinero(200);
        Gasto g1 = new Gasto(c1, "Compre un pantalon", 1);
        String res = g1.toString();
        assertEquals(res, "Bs 200, Compre un pantalon, 1");
    }
}