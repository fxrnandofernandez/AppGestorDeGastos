
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class sugerirCategoriaTest{
    private HistorialDeGastos historial;
    private Gasto gasto1, gasto2, gasto3;

    @Before
    public void setUp(){
        historial = new HistorialDeGastos();
        gasto1 = new Gasto(new Dinero("20"), "Taxi", "12/01/2026", "Transporte", 123);
        gasto2 = new Gasto(new Dinero("20"), "Taxi", "12/01/2026", "Transporte", 123);
        gasto3 = new Gasto(new Dinero("15"), "Taxi", "12/01/2026", "Otros", 123);

        historial.agregarGasto(gasto3);
        historial.agregarGasto(gasto1);
        historial.agregarGasto(gasto2);
    }

    @Test
    public void categoriaMasFrecuente(){
        String resultado = historial.sugerirCategoria("Taxi");
        assertEquals("Transporte", resultado);
    }
    
    @Test
    public void sinAntecedentes(){
        HistorialDeGastos historial = new HistorialDeGastos();
        Gasto gasto = new Gasto(new Dinero("12"), "Almuerzo", "12/01/2026", "comida", 123);
        historial.agregarGasto(gasto);
        String resultado = historial.sugerirCategoria("Zapatos");
        assertEquals("", resultado);
    }
    
    @Test
    public void gastosViejosSinCategoria(){
        HistorialDeGastos historial = new HistorialDeGastos();
        Gasto gasto = new Gasto(new Dinero("20"), "Taxi", "12/01/2026", "", 123);
        historial.agregarGasto(gasto);
        String resultado = historial.sugerirCategoria("Taxi");
        assertEquals("", resultado);
    }
    
    @Test
    public void categoriaVaciaIgnorada(){
        HistorialDeGastos historial = new HistorialDeGastos();
        historial.agregarGasto(new Gasto(new Dinero("20"), "Taxi", "12/01/2026", "", 123));
        historial.agregarGasto(new Gasto(new Dinero("20"), "Taxi", "12/01/2026", "", 123));
        historial.agregarGasto(new Gasto(new Dinero("20"), "Taxi", "12/01/2026", "Transporte", 123));
        
        String resultado = historial.sugerirCategoria("Taxi");
        assertEquals("Transporte", resultado);
    }
}