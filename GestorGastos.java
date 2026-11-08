import java.util.ArrayList;

/**
 * Write a description of class ControlDeGasto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestorGastos
{
    
    public String registrarGasto(Dinero monto, String descripcion, String fecha, String categoria){
        String mensaje;
    
        if(categoria == null){
            mensaje = "Debe llenar la categoria";
        }else if(descripcion == null){
            mensaje = "Debe llenar la descripcion";
        }else if(monto == null){
            mensaje = "El monto esta vacio";
        }else{
            mensaje = "Registro exitoso";
        }
        return mensaje;
    }
    
}