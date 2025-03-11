package decorator;

import factoryMethod.Carro;

public abstract class CarroDecorator extends Carro {
    protected Carro carroDecorado;

    public CarroDecorator(Carro carroDecorado) {
        super(carroDecorado.getModelo(), carroDecorado.getPreco());
        this.carroDecorado = carroDecorado;

        if (!carroDecorado.isEmManutencao()) {
            throw new IllegalStateException("O carro não está em manutenção. Personalização não permitida.");
        }
    }

    @Override
    public String descricao() {
        return carroDecorado.descricao();
    }

    @Override
    public double getPreco() {
        return carroDecorado.getPreco();
    }
}