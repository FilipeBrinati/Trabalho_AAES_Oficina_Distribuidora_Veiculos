package state;

import factoryMethod.Carro;

public interface EstadoCarro {
    void realizarManutencao(Carro carro);
    void entregarCarro(Carro carro);
}