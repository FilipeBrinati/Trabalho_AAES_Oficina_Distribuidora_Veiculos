package strategy;

import abstractFactory.FabricaPeças;
import factoryMethod.Carro;

public interface EstrategiaManutencao {
    void realizarManutencao(Carro carro, FabricaPeças fabricaPeças);
}