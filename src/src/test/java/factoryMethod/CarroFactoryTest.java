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
    
    @Test
    void testCriarCaminhão() {
        CarroFactory factory = new CaminhãoFactory();
        Carro carro = factory.criarCarro();
        assertEquals("Caminhão", carro.getModelo());
        assertEquals(120000.0, carro.getPreco());
    }
    
    @Test
    void testCriarPickup() {
        CarroFactory factory = new PickupFactory();
        Carro carro = factory.criarCarro();
        assertEquals("Pickup", carro.getModelo());
        assertEquals(80000.0, carro.getPreco());
    }
    
    @Test
    void testCriarHatch() {
        CarroFactory factory = new HatchFactory();
        Carro carro = factory.criarCarro();
        assertEquals("Hatch", carro.getModelo());
        assertEquals(40000.0, carro.getPreco());
    }
    
    @Test
    void testCarroBasico() {
        Carro carro = new SedanFactory().criarCarro();
        assertEquals("Carro: Sedan, Preço: 50000.0", carro.descricao());
        assertEquals(50000.0, carro.getPreco());
        assertFalse(carro.isEmManutencao()); 
    }

    @Test
    void testSetEmManutencao() {
        Carro carro = new SedanFactory().criarCarro();
        carro.setEmManutencao(true);
        assertTrue(carro.isEmManutencao());

        carro.setEmManutencao(false);
        assertFalse(carro.isEmManutencao());
    }
}