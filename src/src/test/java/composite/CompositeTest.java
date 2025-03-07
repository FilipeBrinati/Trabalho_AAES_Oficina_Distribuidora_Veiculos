package composite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompositeTest {
    @Test
    void testDescricao() {
        Peça peça = new Peça("Motor", 5000.0);
        assertEquals("Peça: Motor", peça.descricao());
    }

    @Test
    void testGetPreco() {
        Peça peça = new Peça("Motor", 5000.0);
        assertEquals(5000.0, peça.getPreco());
    }

    @Test
    void testAdicionarComponente() {
        KitCarro kit = new KitCarro();
        Peça peça = new Peça("Motor", 5000.0);
        kit.adicionar(peça);

        assertTrue(kit.descricao().contains("Peça: Motor"));
    }

    @Test
    void testDescricaoComVariosComponentes() {
        KitCarro kit = new KitCarro();
        kit.adicionar(new Peça("Motor", 5000.0));
        kit.adicionar(new Peça("Pneu", 1000.0));

        String descricao = kit.descricao();
        assertTrue(descricao.contains("Peça: Motor"));
        assertTrue(descricao.contains("Peça: Pneu"));
    }

    @Test
    void testGetPrecoTotal() {
        KitCarro kit = new KitCarro();
        kit.adicionar(new Peça("Motor", 5000.0));
        kit.adicionar(new Peça("Pneu", 1000.0));

        assertEquals(6000.0, kit.getPreco());
    }
}