package Decorator;

public class SistemaSomPremiumDecorator extends CarroDecorator {
    public SistemaSomPremiumDecorator(Carro carro) {
        super(carro);
    }

    @Override
    public String descricao() {
        return carro.descricao() + ", Sistema de Som Premium";
    }

    @Override
    public double getPreco() {
        return carro.getPreco() + 1500.0;
    }
}