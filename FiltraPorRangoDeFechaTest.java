
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class FiltraPorRangoDeFechaTest{
    private HistorialDeGastos historial;
    private Gasto gasto1, gasto2, gasto3;
    @Before
    public void setUp(){
        historial = new HistorialDeGastos();
        gasto1 = new Gasto(new Dinero("12"), "Almuerzo", "12/01/2026", "comida", 123);
        gasto2 = new Gasto(new Dinero("20"), "Taxi", "12/01/2026", "Transporte", 123);
        gasto3 = new Gasto(new Dinero("50"), "Cine", "23/01/2026", "Entretenimiento", 123);
        historial.agregarGasto(gasto1);         
        historial.agregarGasto(gasto2);
        historial.agregarGasto(gasto3);
    }
    
    @Test
    public void rangoSinGastos(){
        ArrayList<Gasto> resultado = historial.filtrarPorRango("01/02/2026", "10/02/2026");   // el reusltado seria un tipo de array donde copio todo lo de la lista nueva, en
        
        assertEquals(0, resultado.size());
    }
    
    @Test
    public void rangoDeunSoloDia(){
        ArrayList<Gasto> resultado = historial.filtrarPorRango("12/01/2026", "12/01/2026"); 

        assertEquals(2, resultado.size());
        assertSame(gasto1, resultado.get(0));
        assertSame(gasto2, resultado.get(1));
    }
    
    @Test
    public void rangoInvalido(){
        String resultado = historial.validarPorRango("20/01/2026", "12/01/2026"); 
        assertEquals("Rango invalido", resultado);
        
    }
    
    @Test
    public void fechaInexistente() {
        String resultado = historial.validarPorRango("32/13/2026", "12/01/2026");
        assertEquals("Fecha incorrecta", resultado);
    }
   
}
 
