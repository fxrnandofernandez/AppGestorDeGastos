/**
 * Write a description of class ControlDeGasto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gasto
{
    public String registrarGasto(int gasto){
        String mensaje;
        if(gasto > 0){
            mensaje = "Registro exitoso";
        }else {
            mensaje = "Cantidad no valida";    
        }
        return mensaje;
    }
    
}