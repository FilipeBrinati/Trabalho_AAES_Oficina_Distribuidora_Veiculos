package factoryMethod;

public class PickupFactory extends CarroFactory {
    @Override
    public Carro criarCarro() {
        return new Pickup();
    }
}