package state;

import factoryMethod.Carro;

public class ProntoParaEntrega implements EstadoCarro {
    @Override
    public String realizarManutencao(Carro carro) {
        return "O carro " + carro.getModelo() + " foi enviado para manutenção.";
    }

    @Override
    public String entregarCarro(Carro carro) {
        return "O carro " + carro.getModelo() + " foi entregue ao cliente.";
    }
}