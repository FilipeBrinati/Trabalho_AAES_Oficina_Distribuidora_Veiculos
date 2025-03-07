package abstractFactory;

import org.junit.jupiter.api.Test;

import composite.Peça;

import static org.junit.jupiter.api.Assertions.*;

class FabricaPeçasTest {
    @Test
    void testFabricaPeçasSedan() {
        FabricaPeças fabrica = new FabricaPeçasSedan();
        Peça motor = fabrica.createMotor();
        Peça pneu = fabrica.createPneu();
        Peça componente = fabrica.createComponenteEspecifico();

        assertEquals("Peça: Motor Sedan", motor.descricao());
        assertEquals("Peça: Pneu Sedan", pneu.descricao());
        assertEquals("Peça: Suspensão Esportiva", componente.descricao());
    }

    @Test
    void testFabricaPeçasSUV() {
        FabricaPeças fabrica = new FabricaPeçasSUV();
        Peça motor = fabrica.createMotor();
        Peça pneu = fabrica.createPneu();
        Peça componente = fabrica.createComponenteEspecifico();

        assertEquals("Peça: Motor SUV", motor.descricao());
        assertEquals("Peça: Pneu SUV", pneu.descricao());
        assertEquals("Peça: Tração 4x4", componente.descricao());
    }
}