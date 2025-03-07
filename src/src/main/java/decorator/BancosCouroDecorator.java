package decorator;

import factoryMethod.Carro;

public class BancosCouroDecorator extends CarroDecorator {
    public BancosCouroDecorator(Carro carroDecorado) {
        super(carroDecorado);
    }

    @Override
    public String descricao() {
        return carroDecorado.descricao() + ", Bancos de Couro";
    }

    @Override
    public double getPreco() {
        return carroDecorado.getPreco() + 2000.0;
    }
}