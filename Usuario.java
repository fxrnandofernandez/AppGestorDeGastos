
import java.time.LocalDate;
import java.util.LinkedList;

public class Usuario {
    private String nombre;
    private String correo;
    private String contrasenia;
    public Usuario(){}
    public Usuario(String nombre, String correo, String contrasenia) {
        this.nombre      = nombre;
        this.correo      = correo;
        this.contrasenia = contrasenia;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getCorreo(){
        return correo;
    }
    public String getcontrasenia(){
        return contrasenia;
    }
    
    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }
    public void setCorreo(String nuevoCorreo){
        correo = nuevoCorreo;
    }
    public void setContrasenia(String nuevaContra){
        contrasenia = nuevaContra;
    }
}
