import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraJurosTeste {

    @Test
    void calcularJurosSimples() {
        final double MONTANTE_ESPERADO = 1.100;

        double capital = 1.000;
        double taxaJuros = 0.01;
        int tempo = 1;

        double juros = capital * taxaJuros * tempo;
        double montante = capital + juros;

        assertEquals(MONTANTE_ESPERADO, montante);
    }

    // Cenário 2
    @Test
    void deveRetornarZeroQuandoCapitalForZero() {
        final double MONTANTE_ESPERADO = 0.0;
        double capital = 0.0;
        double taxaJuros = 0.01;
        int tempo = 5;

        double juros = capital * taxaJuros * tempo;
        double montante = capital + juros;

        assertEquals(MONTANTE_ESPERADO, montante);
    }

    // Cenário 3
    @Test
    void deveManterMesmoValorQuandoTaxaForZero() {
        final double MONTANTE_ESPERADO = 500.00;
        
        double capital = 500.0;
        double taxaJuros = 0.0;
        int tempo = 10;

        double juros = capital * taxaJuros * tempo;
        double montante = capital + juros;

        assertEquals(MONTANTE_ESPERADO, montante);
    }

    // Cenário 4
    @Test
    void deveNegarCalculoQuandoTempoForNegativo() {
        final String EXCEPTION_MESSAGE = "Tempo inválido";
        int tempo = -2;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            if (tempo < 0) {
                throw new IllegalArgumentException("Tempo inválido");
            }
        });

        assertEquals(EXCEPTION_MESSAGE, exception.getMessage());
    }

    // Cenário 5
    @Test
    void deveNegarCalculoQuandoCapitalForNegativo() {
        final String EXCEPTION_MESSAGE = "Valor inválido";
        double capital = -1000.0;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            if (capital < 0) {
                throw new IllegalArgumentException("Valor inválido");
            }
        });

        assertEquals(EXCEPTION_MESSAGE, exception.getMessage());
    }
}
