package abstractFactory;

import composite.Peça;

public class FabricaPeçasHatch implements FabricaPeças {
    @Override
    public Peça createMotor() {
        return new Peça("Motor Hatch", 4000.0);
    }

    @Override
    public Peça createPneu() {
        return new Peça("Pneu Hatch", 1500.0);
    }

    @Override
    public Peça createComponenteEspecifico() {
        return new Peça("Aerofólio Esportivo", 2000.0);
    }
}