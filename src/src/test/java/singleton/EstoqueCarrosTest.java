package singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import factoryMethod.Carro;
import factoryMethod.SedanFactory;
import observer.Cliente;

class EstoqueCarrosTest {
    @Test
    void testSingleton() {
        EstoqueCarros estoque1 = EstoqueCarros.getInstance();
        EstoqueCarros estoque2 = EstoqueCarros.getInstance();
        assertSame(estoque1, estoque2);
    }

    @Test
    void testAdicionarCarro() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        Carro carro = new SedanFactory().criarCarro();
        Cliente cliente = new Cliente("João");
        estoque.addObserver(cliente);

        String resultado = estoque.adicionarCarro(carro);

        assertEquals("Carro Sedan adicionado ao estoque.", resultado);
        assertEquals("João recebeu a notificação: Novo carro disponível: Sedan", cliente.getUltimaNotificacao());
    }

    @Test
    void testAdicionarCarroEmManutencao() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        Carro carro = new SedanFactory().criarCarro();
        Cliente cliente = new Cliente("Maria");
        estoque.addObserver(cliente);

        String resultado = estoque.adicionarCarroEmManutencao(carro);

        assertEquals("Carro Sedan enviado para manutenção.", resultado);
        assertEquals("Maria recebeu a notificação: O carro Sedan foi enviado para manutenção.", cliente.getUltimaNotificacao());
    }

    @Test
    void testRemoverCarroEmManutencao() {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        Carro carro = new SedanFactory().criarCarro();
        Cliente cliente = new Cliente("Pedro");
        estoque.addObserver(cliente);

        estoque.adicionarCarroEmManutencao(carro);
        String resultado = estoque.removerCarroEmManutencao(carro);

        assertEquals("Carro Sedan pronto para entrega.", resultado);
        assertEquals("Pedro recebeu a notificação: O carro Sedan está pronto para entrega.", cliente.getUltimaNotificacao());
    }
}
