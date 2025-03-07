package factoryMethod;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarroFactoryTest {
    @Test
    void testCriarSedan() {
        CarroFactory factory = new SedanFactory();
        Carro carro = factory.criarCarro();
        assertEquals("Sedan", carro.getModelo());
        assertEquals(50000.0, carro.getPreco());
    }

    @Test
    void testCriarSUV() {
        CarroFactory factory = new SUVFactory();
        Carro carro = factory.criarCarro();
        assertEquals("SUV", carro.getModelo());
        assertEquals(70000.0, carro.getPreco());
    }
}