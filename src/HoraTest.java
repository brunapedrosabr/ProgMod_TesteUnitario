import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HoraTest{
    @Test
    public void testaInvalido(){
        Hora h1 = new Hora(24,0,0);
        //assertFalse(h1.ehValida()); 
        assertEquals("00:00:00",h1.horaFormatada());
    }

    @Test
    public void testaIncrementoHora(){
        Hora h1 = new Hora(12,00,00);
        h1 = h1.incrementar(70);
        assertEquals("13:10:00",h1.horaFormatada());
    }

    @Test 
    public void testaComparacao(){
        Hora h1 = new Hora(15,30,00);
        Hora h2 = new Hora(16,10,00);
        assertTrue(h1.estahNaFrenteDe(h2));
    }
}