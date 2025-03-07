package observer;

import org.junit.jupiter.api.Test;

import factoryMethod.Carro;
import factoryMethod.SedanFactory;
import singleton.EstoqueCarros;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void testUpdate() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        Cliente cliente = new Cliente("João");
        estoque.addObserver(cliente);

        Carro carro = new SedanFactory().criarCarro();
        estoque.adicionarCarro(carro);

        assertEquals("João recebeu a notificação: Novo carro disponível: Sedan", cliente.getUltimaNotificacao());
    }
}