import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraJurosTeste {

    @Test
    void calcularJurosSimples() {
        final double MONTANTE_ESPERADO = 1100.0;

        CalculadoraJuros calculadora = new CalculadoraJuros();
        double montante = calculadora.calcularJurosSimples(1000.0, 0.1, 1);

        assertEquals(MONTANTE_ESPERADO, montante);
    }

    @Test
    void deveRetornarZeroQuandoCapitalForZero() {
        final double MONTANTE_ESPERADO = 0.0;

        CalculadoraJuros calculadora = new CalculadoraJuros();
        double montante = calculadora.calcularJurosSimples(0.0, 0.01, 5);

        assertEquals(MONTANTE_ESPERADO, montante);
    }

    @Test
    void deveManterMesmoValorQuandoTaxaForZero() {
        final double MONTANTE_ESPERADO = 500.0;

        CalculadoraJuros calculadora = new CalculadoraJuros();
        double montante = calculadora.calcularJurosSimples(500.0, 0.0, 10);

        assertEquals(MONTANTE_ESPERADO, montante);
    }

    @Test
    void deveNegarCalculoQuandoTempoForNegativo() {
        CalculadoraJuros calculadora = new CalculadoraJuros();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularJurosSimples(1000.0, 0.01, -2);
        });

        assertEquals("Tempo inválido", exception.getMessage());
    }

    @Test
    void deveNegarCalculoQuandoCapitalForNegativo() {
        CalculadoraJuros calculadora = new CalculadoraJuros();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularJurosSimples(-1000.0, 0.01, 2);
        });

        assertEquals("Valor inválido", exception.getMessage());
    }
}