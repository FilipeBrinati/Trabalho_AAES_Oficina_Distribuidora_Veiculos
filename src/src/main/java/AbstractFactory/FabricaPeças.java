package AbstractFactory;

public interface FabricaPeças {
    Motor createMotor();
    Pneu createPneu();
    SistemaEletrico createSistemaEletrico();
}
