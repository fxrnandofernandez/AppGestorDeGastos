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
public class GestorGastosTest
{
    private GestorGastos gestor;
    /**
     * Default constructor for test class xd
     */
    public GestorGastosTest()
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
        gestor = new GestorGastos();
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
    public void testMensajeDeRegistroExitoso(){
        Dinero monto = new Dinero("200");
        String descripcion = "Compre un teclado gamer";
        String fecha = Fecha.obtenerFechaYHora();
        String categoria = "Gadgets";
        String resultado = gestor.registrarGasto(monto, descripcion, fecha, categoria);
        assertEquals("Registro exitoso", resultado);
    }
    
    @Test
    public void testCategoriaVaciaMensajeDeLlenadoObligatorio(){
        Dinero monto = new Dinero("100");
        String descripcion = "";
        String fecha = Fecha.obtenerFechaYHora();
        String categoria = null;
        String resultado = gestor.registrarGasto(monto, descripcion, fecha, categoria);
        assertEquals("Debe llenar la categoria", resultado);
    }
    
    @Test 
    public void testDescripcionVaciaMensajeDeLLenadoObligatorio(){
        Dinero monto = new Dinero("150");
        String descripcion = null;
        String fecha = Fecha.obtenerFechaYHora();
        String categoria = "Alimentacion";
        String resultado = gestor.registrarGasto(monto, descripcion, fecha, categoria);
        assertEquals("Debe llenar la descripcion", resultado);
    }
    
    @Test
     public void testMontoVacioMensajeDeLLenadoObligatorio(){
        Dinero monto = null;
        String descripcion = "Compre una salchipapa";
        String fecha = Fecha.obtenerFechaYHora();
        String categoria = "Alimentacion";
        String resultado = gestor.registrarGasto(monto, descripcion, fecha, categoria);
        assertEquals("El monto esta vacio", resultado);
    }
}