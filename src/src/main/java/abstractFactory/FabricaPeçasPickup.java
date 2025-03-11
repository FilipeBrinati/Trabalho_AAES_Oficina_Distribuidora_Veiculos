package abstractFactory;

import composite.Peça;

public class FabricaPeçasPickup implements FabricaPeças {
    @Override
    public Peça createMotor() {
        return new Peça("Motor Pickup", 7000.0);
    }

    @Override
    public Peça createPneu() {
        return new Peça("Pneu Pickup", 3000.0);
    }

    @Override
    public Peça createComponenteEspecifico() {
        return new Peça("Caçamba Reforçada", 5000.0);
    }
}