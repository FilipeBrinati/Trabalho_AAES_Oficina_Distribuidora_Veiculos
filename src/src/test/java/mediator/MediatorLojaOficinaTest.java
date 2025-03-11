package mediator;

import org.junit.jupiter.api.Test;
import factoryMethod.Carro;
import factoryMethod.SedanFactory;
import observer.Cliente;
import singleton.EstoqueCarros;

import static org.junit.jupiter.api.Assertions.*;

class MediatorLojaOficinaTest {

    @Test
    void testAdicionarCliente() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        MediatorLojaOficina mediator = new MediatorLojaOficina(estoque);
        Cliente cliente = new Cliente("João");

        mediator.adicionarCliente(cliente);

        assertTrue(mediator.getClientes().contains(cliente));
    }

    @Test
    void testVenderCarro() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        MediatorLojaOficina mediator = new MediatorLojaOficina(estoque);
        Carro carro = new SedanFactory().criarCarro();
        Cliente cliente = new Cliente("João");

        mediator.adicionarCliente(cliente);
        String resultado = mediator.venderCarro(carro, cliente);

        assertEquals("Carro Sedan adicionado ao estoque.", resultado);
        assertTrue(cliente.getUltimaNotificacao().contains("João recebeu a notificação: Novo carro disponível: Sedan"));
        assertTrue(cliente.getCarros().contains(carro));
    }

    @Test
    void testEnviarParaManutencao() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        MediatorLojaOficina mediator = new MediatorLojaOficina(estoque);
        Carro carro = new SedanFactory().criarCarro();

        String resultado = mediator.enviarParaManutencao(carro);
        assertEquals("Carro Sedan enviado para manutenção.", resultado);
        assertTrue(carro.isEmManutencao()); // Verifica se o carro está em manutenção
    }

    @Test
    void testFinalizarManutencao() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        MediatorLojaOficina mediator = new MediatorLojaOficina(estoque);
        Carro carro = new SedanFactory().criarCarro();

        mediator.enviarParaManutencao(carro); // Envia o carro para manutenção
        String resultado = mediator.finalizarManutencao(carro);
        assertEquals("Carro Sedan pronto para entrega.", resultado);
        assertFalse(carro.isEmManutencao()); // Verifica se o carro não está mais em manutenção
    }
}