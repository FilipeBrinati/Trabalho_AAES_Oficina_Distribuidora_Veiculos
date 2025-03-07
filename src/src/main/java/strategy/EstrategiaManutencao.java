package strategy;

import abstractFactory.FabricaPeças;
import factoryMethod.Carro;

public interface EstrategiaManutencao {
    String realizarManutencao(Carro carro, FabricaPeças fabricaPeças);
}