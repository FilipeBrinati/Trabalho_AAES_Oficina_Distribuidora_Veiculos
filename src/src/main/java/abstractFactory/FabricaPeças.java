package abstractFactory;

public interface FabricaPeças {
    Motor createMotor();
    Pneu createPneu();
    SistemaEletrico createSistemaEletrico();
}
