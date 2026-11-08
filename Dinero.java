import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Dinero{
    private final BigDecimal monto;
    
    public Dinero(String valor){
        BigDecimal t = new BigDecimal(valor);
        this.monto = t.setScale(2, RoundingMode.HALF_UP);
    }
    
    @Override
    public String toString(){
        return "Bs " + monto.toString();
    }
    
    
}