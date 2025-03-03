package AbstractFactory;

public class FabricaPecasSedan implements FabricaPeças {
    @Override
    public Motor createMotor() {
        return new Motor("Motor Sedan");
    }

    @Override
    public Pneu createPneu() {
        return new Pneu("Pneu Sedan");
    }

    @Override
    public SistemaEletrico createSistemaEletrico() {
        return new SistemaEletrico("Sistema Elétrico Sedan");
    }
}