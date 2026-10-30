
/**
 * Write a description of class Gasto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gasto
{
   private Dinero monto;
   private String descripcion;
   private int IDUsuario;
   public Gasto(Dinero monto, String descripcion, int IDUsuario){
       this.monto = monto;
       this.descripcion = descripcion;
       this.IDUsuario = IDUsuario;
   }
   
   @Override
   public String toString(){
       return monto.toString() +", "+descripcion+ ", "+ IDUsuario;
   }
}