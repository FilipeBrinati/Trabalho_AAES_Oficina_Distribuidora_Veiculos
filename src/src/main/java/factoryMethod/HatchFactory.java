package factoryMethod;

public class HatchFactory extends CarroFactory {
    @Override
    public Carro criarCarro() {
        return new Hatch();
    }
}