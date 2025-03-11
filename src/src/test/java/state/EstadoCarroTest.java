package state;

import org.junit.jupiter.api.Test;

import factoryMethod.Carro;
import factoryMethod.SedanFactory;

import static org.junit.jupiter.api.Assertions.*;

class EstadoCarroTest {
	@Test
    void testAvancarEstado() {
        Carro carro = new SedanFactory().criarCarro();

        assertTrue(carro.getEstado() instanceof ProntoParaEntrega);

        String mensagem1 = carro.avancarEstado();
        assertEquals("Carro Sedan foi enviado para manutenção.", mensagem1);
        assertTrue(carro.getEstado() instanceof EmManutencao);

        String mensagem2 = carro.avancarEstado();
        assertEquals("Carro Sedan está pronto para entrega.", mensagem2);
        assertTrue(carro.getEstado() instanceof ProntoParaEntrega);
    }
}