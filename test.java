import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class test{
    public test(){}
    
    @Test
    public void test1(){
        String n = "Al";
        String correo = "adolfo@gmail.com";
        String contra = "adolf";

        Usuario u = new Usuario();

        boolean res = u.registrarUsuario(n, correo, contra);

        assertFalse(res);
        assertEquals("Ingrese un nombre valido", u.getMensaje());
    }
}