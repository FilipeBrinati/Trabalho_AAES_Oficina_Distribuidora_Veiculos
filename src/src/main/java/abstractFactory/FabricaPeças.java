package abstractFactory;

import composite.Peça;

public interface FabricaPeças {
    Peça createMotor();
    Peça createPneu();
    Peça createComponenteEspecifico();
}