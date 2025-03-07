package decorator;

import org.junit.jupiter.api.Test;

import factoryMethod.Carro;
import factoryMethod.SedanFactory;

import static org.junit.jupiter.api.Assertions.*;

class CarroDecoratorTest {
    @Test
    void testBancosCouroDecorator() {
        Carro carro = new SedanFactory().criarCarro();
        Carro decorado = new BancosCouroDecorator(carro);
        assertEquals("Carro: Sedan, Preço: 50000.0, Bancos de Couro", decorado.descricao());
        assertEquals(52000.0, decorado.getPreco());
    }

    @Test
    void testSistemaSomPremiumDecorator() {
        Carro carro = new SedanFactory().criarCarro();
        Carro decorado = new SistemaSomPremiumDecorator(carro);
        assertEquals("Carro: Sedan, Preço: 50000.0, Sistema de Som Premium", decorado.descricao());
        assertEquals(51500.0, decorado.getPreco());
    }
}