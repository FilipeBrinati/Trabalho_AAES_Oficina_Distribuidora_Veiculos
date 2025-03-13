package state;

import factoryMethod.Carro;

public class EmManutencao implements EstadoCarro {
    @Override
    public String avancar(Carro carro) {
        carro.setEstado(new ProntoParaEntrega());
        return "Carro " + carro.getModelo() + " pronto para entrega.";
    }
}