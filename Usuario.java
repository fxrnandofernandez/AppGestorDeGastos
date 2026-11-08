public class Usuario {
        private int id;
        private String nombre;
        private String correo;
        private String contrasenia;
        public Usuario(){}
        public Usuario(int id, String nombre, String correo, String contrasenia) {
            this.id          = id;
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
        public int getID(){
            return id;
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