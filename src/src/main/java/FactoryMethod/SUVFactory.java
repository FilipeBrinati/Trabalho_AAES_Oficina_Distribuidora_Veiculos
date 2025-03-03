package FactoryMethod;

public class SUVFactory extends CarroFactory {
    @Override
    public Carro criarCarro() {
        return new SUV();
    }
}