package abstractFactory;

import composite.Peça;

public class FabricaPeçasSUV implements FabricaPeças {
    @Override
    public Peça createMotor() {
        return new Peça("Motor SUV", 6000.0);
    }

    @Override
    public Peça createPneu() {
        return new Peça("Pneu SUV", 2500.0);
    }

    @Override
    public Peça createComponenteEspecifico() {
        return new Peça("Tração 4x4", 4000.0);
    }
}