import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Dinero{
    private final BigDecimal monto;
    
    public Dinero(String valor){
        BigDecimal temporal = new BigDecimal(valor);
        if (temporal.signum() == -1) {
            throw new IllegalArgumentException("Error: El monto de dinero no puede ser negativo (" + valor + ").");
        }
        this.monto = temporal.setScale(2, RoundingMode.HALF_UP);
    }
    
    
    public String convertirACadena(){
        return "Bs " + monto.toString();
    }
}