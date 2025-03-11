package decorator;

import factoryMethod.Carro;

public class RodasEsportivasDecorator extends CarroDecorator {
    public RodasEsportivasDecorator(Carro carroDecorado) {
        super(carroDecorado);
    }

    @Override
    public String descricao() {
        return carroDecorado.descricao() + ", Rodas Esportivas";
    }

    @Override
    public double getPreco() {
        return carroDecorado.getPreco() + 2500.0;
    }
}