package decorator;

import factoryMethod.Carro;

public class PinturaEspecialDecorator extends CarroDecorator {
    public PinturaEspecialDecorator(Carro carroDecorado) {
        super(carroDecorado);
    }

    @Override
    public String descricao() {
        return carroDecorado.descricao() + ", Pintura Especial";
    }

    @Override
    public double getPreco() {
        return carroDecorado.getPreco() + 2000.0;
    }
}