package state;

import factoryMethod.Carro;

public interface EstadoCarro {
    String realizarManutencao(Carro carro);
    String entregarCarro(Carro carro);
}