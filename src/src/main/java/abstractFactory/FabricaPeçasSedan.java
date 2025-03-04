package abstractFactory;

import composite.Peça;

public class FabricaPeçasSedan implements FabricaPeças {
    @Override
    public Peça createMotor() {
        return new Peça("Motor Sedan", 5000.0);
    }

    @Override
    public Peça createPneu() {
        return new Peça("Pneu Sedan", 2000.0);
    }

    @Override
    public Peça createComponenteEspecifico() {
        return new Peça("Suspensão Esportiva", 3000.0);
    }
}