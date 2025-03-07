package decorator;

import factoryMethod.Carro;

public class SistemaSomPremiumDecorator extends CarroDecorator {
    public SistemaSomPremiumDecorator(Carro carroDecorado) {
        super(carroDecorado);
    }

    @Override
    public String descricao() {
        return carroDecorado.descricao() + ", Sistema de Som Premium";
    }

    @Override
    public double getPreco() {
        return carroDecorado.getPreco() + 1500.0;
    }
}