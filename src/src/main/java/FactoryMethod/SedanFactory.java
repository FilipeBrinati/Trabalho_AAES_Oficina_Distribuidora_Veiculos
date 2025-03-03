package FactoryMethod;

public class SedanFactory extends CarroFactory {
    @Override
    public Carro criarCarro() {
        return new Sedan();
    }
}
