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

    @Test
    void testAdicionarCarro() {
        Cliente cliente = new Cliente("Maria");
        Carro carro = new SedanFactory().criarCarro();

        cliente.adicionarCarro(carro);

        assertTrue(cliente.getCarros().contains(carro));
    }

    @Test
    void testGetCarros() {
        Cliente cliente = new Cliente("Pedro");
        Carro carro1 = new SedanFactory().criarCarro();
        Carro carro2 = new SedanFactory().criarCarro();

        cliente.adicionarCarro(carro1);
        cliente.adicionarCarro(carro2);

        assertEquals(2, cliente.getCarros().size());
        assertTrue(cliente.getCarros().contains(carro1));
        assertTrue(cliente.getCarros().contains(carro2));
    }
}