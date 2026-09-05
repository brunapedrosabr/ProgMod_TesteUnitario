import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Testes da Classe Hora")
public class HoraTest{

    /*@BeforeEach 
    void setUp(){
        Hora h1 = new Hora(24,00,00);
    }*/

    @Test
    public void testaInvalido(){
        Hora h1 = new Hora(24,0,0);
        //assertFalse(h1.ehValida()); 
        assertEquals("00:00:00",h1.horaFormatada());
    }

    @DisplayName ("Testa Incrementar")
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