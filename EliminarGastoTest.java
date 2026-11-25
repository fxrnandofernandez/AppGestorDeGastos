

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
public class EliminarGastoTest{
    private HistorialDeGastos historial;
    private Gasto gasto1, gasto2, gasto3;
    @Before
    public void setUp(){
        historial = new HistorialDeGastos();
        gasto1 = new Gasto(new Dinero("12"), "Almuerzo", "12/01/2026", "comida", 123);
        gasto2 = new Gasto(new Dinero("12"), "Taxi", "12/01/2026", "Transporte", 123);
        gasto3 = new Gasto(new Dinero("12"), "Cine", "23/01/2026", "Entretenimiento", 123);
        historial.agregarGasto(gasto1);         
        historial.agregarGasto(gasto2);
        historial.agregarGasto(gasto3);
    }
    @After
    public void tearDown(){
    }
    @Test
    public void testEliminarUnGastoExistente(){
        String resultado = historial.eliminarGasto(1);
        assertEquals("Gasto Eliminado", resultado);
        assertEquals(2, historial.getTamanio());
    }
    
    @Test
    public void  testPosicionMayorAlTamanio(){
        String resultado = historial.eliminarGasto(5);
        assertEquals("Posicion invalida", resultado);
        assertEquals(3, historial.getTamanio());
    }
    
    @Test
    public void  testPosicionNegativa(){
        String resultado = historial.eliminarGasto(-1);
        assertEquals("Posicion invalida", resultado);
        assertEquals(3, historial.getTamanio());
    }
    
    @Test
    public void testHistorialVacio(){
        HistorialDeGastos historialVacio = new HistorialDeGastos();
        String resultado = historialVacio.eliminarGasto(0);
        assertEquals("Historial vacío", resultado);
        assertEquals(0, historialVacio.getTamanio());
    }
}



    
/**
       //ARRange preparo todo lo necesario
        HistorialDeGastos historial = new HistorialDeGastos();//la clase historialDeGastos es como la libreta donde anoto los gastos, entonce me correponde que esa clase tenga funcionalidaddes como las dde eliminar gasto
        Gasto g1 = new Gasto((new Dinero("12")), "Almuerzo", "12/01/2026", "comida", 123);//creo un gasto q se ira al histoDeGastos
        historial.agregarGasto(g1);
        
        //Act, llamada al metodo
        String resultado = historial.eliminarGasto(1);// elimina el gasto de la posicion 1 que seria el primer gasto creado
        
        //Assert , comprobar
        assertEquals("Gasto Eliminado",resultado);
        assertEquals(2, historial.getTamanio());//con esto verificas que solo hay dos elementos , depues de elimiar un gasto de los 3 que dice el criterio
  
**/


