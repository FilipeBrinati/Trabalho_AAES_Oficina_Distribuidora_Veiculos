package state;

import factoryMethod.Carro;

public class EmManutencao implements EstadoCarro {
    @Override
    public String realizarManutencao(Carro carro) {
        return "O carro " + carro.getModelo() + " já está em manutenção.";
    }

    @Override
    public String entregarCarro(Carro carro) {
        return "O carro " + carro.getModelo() + " está pronto para entrega.";
    }
}