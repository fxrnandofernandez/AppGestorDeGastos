
public class GestorUsuario{
    public Usuario registrarUsuario(String nombre, 
                                    String correo, 
                                    String contrasenia){
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre no puede estar vacío"
            );
        }                                
        if(nombre.length() < 2) {
            throw new IllegalArgumentException(
                "Ingrese un nombre válido"
            );
        }
        if (correo == null || correo.isBlank()){
            throw new IllegalArgumentException(
                "El correo no puede estar vacio"
            );
        }
        if (!correo.contains("@") ||
            !correo.contains(".com") ||
            !correo.contains("gmail")) {
            throw new IllegalArgumentException(
                "Ingrese un correo válido"
            );
        }
        Usuario usuarioR = new Usuario(nombre,
                                     correo,contrasenia);
        return usuarioR;
    }
}