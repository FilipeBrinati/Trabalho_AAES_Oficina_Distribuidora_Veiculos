package decorator;

import factoryMethod.Carro;

public class TetoSolarDecorator extends CarroDecorator {
    public TetoSolarDecorator(Carro carroDecorado) {
        super(carroDecorado);
    }

    @Override
    public String descricao() {
        return carroDecorado.descricao() + ", Teto Solar";
    }

    @Override
    public double getPreco() {
        return carroDecorado.getPreco() + 3000.0;
    }
}