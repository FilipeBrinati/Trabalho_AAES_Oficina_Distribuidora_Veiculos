package decorator;

import org.junit.jupiter.api.Test;

import factoryMethod.Carro;
import factoryMethod.SedanFactory;

import static org.junit.jupiter.api.Assertions.*;

class CarroDecoratorTest {
    @Test
    void testBancosCouroDecorator() {
        Carro carro = new SedanFactory().criarCarro();
        carro.setEmManutencao(true);
        Carro decorado = new BancosCouroDecorator(carro);
        assertEquals("Carro: Sedan, Preço: 50000.0, Bancos de Couro", decorado.descricao());
        assertEquals(52000.0, decorado.getPreco());
    }

    @Test
    void testSistemaSomPremiumDecorator() {
        Carro carro = new SedanFactory().criarCarro();
        carro.setEmManutencao(true);
        Carro decorado = new SistemaSomPremiumDecorator(carro);
        assertEquals("Carro: Sedan, Preço: 50000.0, Sistema de Som Premium", decorado.descricao());
        assertEquals(51500.0, decorado.getPreco());
    }
    
    @Test
    void testPinturaEspecialDecorator() {
        Carro carro = new SedanFactory().criarCarro();
        carro.setEmManutencao(true); // Coloca o carro em manutenção
        Carro decorado = new PinturaEspecialDecorator(carro);
        assertEquals("Carro: Sedan, Preço: 50000.0, Pintura Especial", decorado.descricao());
        assertEquals(52000.0, decorado.getPreco());
    }
    
    @Test
    void testRodasEsportivasDecorator() {
        Carro carro = new SedanFactory().criarCarro();
        carro.setEmManutencao(true); // Coloca o carro em manutenção
        Carro decorado = new RodasEsportivasDecorator(carro);
        assertEquals("Carro: Sedan, Preço: 50000.0, Rodas Esportivas", decorado.descricao());
        assertEquals(52500.0, decorado.getPreco());
    }
    
    @Test
    void testTetoSolarDecorator() {
        Carro carro = new SedanFactory().criarCarro();
        carro.setEmManutencao(true); // Coloca o carro em manutenção
        Carro decorado = new TetoSolarDecorator(carro);
        assertEquals("Carro: Sedan, Preço: 50000.0, Teto Solar", decorado.descricao());
        assertEquals(53000.0, decorado.getPreco());
    }
    
    @Test
    void testAplicarDecoradorEmManutencao() {
        Carro carro = new SedanFactory().criarCarro();
        carro.setEmManutencao(true);
        Carro carroDecorado = new BancosCouroDecorator(carro);
        assertEquals("Carro: Sedan, Preço: 50000.0, Bancos de Couro", carroDecorado.descricao());
        assertEquals(52000.0, carroDecorado.getPreco());
    }

    @Test
    void testAplicarDecoradorForaDeManutencao() {
        Carro carro = new SedanFactory().criarCarro();
        carro.setEmManutencao(false);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new BancosCouroDecorator(carro);
        });

        assertEquals("O carro não está em manutenção. Personalização não permitida.", exception.getMessage());
    }
}