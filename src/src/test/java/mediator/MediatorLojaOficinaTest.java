package mediator;

import org.junit.jupiter.api.Test;

import factoryMethod.Carro;
import factoryMethod.SedanFactory;
import observer.Cliente;
import singleton.EstoqueCarros;

import static org.junit.jupiter.api.Assertions.*;

class MediatorLojaOficinaTest {
    @Test
    void testVenderCarro() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        MediatorLojaOficina mediator = new MediatorLojaOficina(estoque);
        Carro carro = new SedanFactory().criarCarro();
        Cliente cliente = new Cliente("João");
        mediator.adicionarCliente(cliente);
        mediator.venderCarro(carro);
        assertTrue(cliente.getUltimaNotificacao().contains("João recebeu a notificação: Novo carro disponível: Sedan"));
    }

    @Test
    void testEnviarParaManutencao() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        MediatorLojaOficina mediator = new MediatorLojaOficina(estoque);
        Carro carro = new SedanFactory().criarCarro();
        Cliente cliente = new Cliente("Maria");
        mediator.adicionarCliente(cliente);
        mediator.enviarParaManutencao(carro);
        assertTrue(cliente.getUltimaNotificacao().contains("Maria recebeu a notificação: O carro Sedan foi enviado para manutenção."));
    }

    @Test
    void testFinalizarManutencao() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        MediatorLojaOficina mediator = new MediatorLojaOficina(estoque);
        Carro carro = new SedanFactory().criarCarro();
        Cliente cliente = new Cliente("Pedro");
        mediator.adicionarCliente(cliente);
        mediator.enviarParaManutencao(carro);
        mediator.finalizarManutencao(carro);
        assertTrue(cliente.getUltimaNotificacao().contains("Pedro recebeu a notificação: O carro Sedan está pronto para entrega."));
    }
}