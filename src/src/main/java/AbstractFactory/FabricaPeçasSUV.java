package AbstractFactory;

public class FabricaPeçasSUV implements FabricaPeças {
    @Override
    public Motor createMotor() {
        return new Motor("Motor SUV");
    }

    @Override
    public Pneu createPneu() {
        return new Pneu("Pneu SUV");
    }

    @Override
    public SistemaEletrico createSistemaEletrico() {
        return new SistemaEletrico("Sistema Elétrico SUV");
    }
}