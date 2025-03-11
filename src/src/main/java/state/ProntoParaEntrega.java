package state;

import factoryMethod.Carro;

public class ProntoParaEntrega implements EstadoCarro {
    @Override
    public String avancar(Carro carro) {
        carro.setEstado(new EmManutencao());
        return "Carro " + carro.getModelo() + " foi enviado para manutenção.";
    }
}