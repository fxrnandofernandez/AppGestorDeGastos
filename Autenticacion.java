import java.io.*;
import java.util.Scanner;

public class Autenticacion {
  
    public static boolean iniciarSesion(String archivo, Usuario usuario) {
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (esUsuarioValido(linea, usuario)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return false;
    }

    
    private static boolean esUsuarioValido(String linea, Usuario usuario) {
        String[] campos = linea.split(",");
        if (campos.length >= 3) {
            return campos[1].equals(usuario.getNombre()) && campos[2].equalsIgnoreCase(usuario.getCorreo());
        }
        return false;
    }

   public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean acceso = false;
        while (!acceso) {
            System.out.println("Ingresa tu usuario (nombre):");
            String nombre = entrada.nextLine();
            System.out.println("Ingresa tu contraseña (correo):");
            String correo = entrada.nextLine();
            Usuario usuarioIngresado = new Usuario(0, nombre, correo, "");
            acceso = iniciarSesion("usuarios.txt", usuarioIngresado);
            
            if (acceso) {
                System.out.println("ACCESO CONCEDIDO");
            } else {
                System.out.println("Acceso denegado");
            }
        }
        entrada.close();
    }
    
 }