package Decorator;

public abstract class CarroDecorator implements Carro {
    protected Carro carro;

    public CarroDecorator(Carro carro) {
        this.carro = carro;
    }

    @Override
    public String descricao() {
        return carro.descricao();
    }

    @Override
    public double getPreco() {
        return carro.getPreco();
    }
}