package state;

import factoryMethod.Carro;

public class ProntoParaEntrega implements EstadoCarro {
    @Override
    public void realizarManutencao(Carro carro) {
        System.out.println("O carro " + carro.getModelo() + " foi enviado para manutenção.");
    }

    @Override
    public void entregarCarro(Carro carro) {
        System.out.println("O carro " + carro.getModelo() + " foi entregue ao cliente.");
    }
}