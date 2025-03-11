package factoryMethod;

public class CaminhãoFactory extends CarroFactory {
    @Override
    public Carro criarCarro() {
        return new Caminhão();
    }
}