package state;

import org.junit.jupiter.api.Test;

import factoryMethod.Carro;
import factoryMethod.SedanFactory;

import static org.junit.jupiter.api.Assertions.*;

class EstadoCarroTest {
    @Test
    void testEmManutencao() {
        Carro carro = new SedanFactory().criarCarro();
        EstadoCarro estado = new EmManutencao();
        assertEquals("O carro Sedan já está em manutenção.", estado.realizarManutencao(carro));
        assertEquals("O carro Sedan está pronto para entrega.", estado.entregarCarro(carro));
    }

    @Test
    void testProntoParaEntrega() {
        Carro carro = new SedanFactory().criarCarro();
        EstadoCarro estado = new ProntoParaEntrega();
        assertEquals("O carro Sedan foi enviado para manutenção.", estado.realizarManutencao(carro));
        assertEquals("O carro Sedan foi entregue ao cliente.", estado.entregarCarro(carro));
    }
}