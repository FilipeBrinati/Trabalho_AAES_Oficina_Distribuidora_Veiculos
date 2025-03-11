package abstractFactory;

import composite.Peça;

public class FabricaPeçasCaminhão implements FabricaPeças {
    @Override
    public Peça createMotor() {
        return new Peça("Motor Caminhão", 10000.0);
    }

    @Override
    public Peça createPneu() {
        return new Peça("Pneu Caminhão", 5000.0);
    }

    @Override
    public Peça createComponenteEspecifico() {
        return new Peça("Eixo Duplo", 8000.0);
    }
}