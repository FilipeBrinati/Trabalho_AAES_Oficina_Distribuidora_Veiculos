package state;

import singleton.EstoqueCarros;
import factoryMethod.Carro;

public class ProntoParaEntrega implements EstadoCarro {
    @Override
    public void realizarManutencao(Carro carro) {
        EstoqueCarros.getInstance().adicionarCarroEmManutencao(carro);
        System.out.println("O carro " + carro.getModelo() + " foi enviado para manutenção.");
    }

    @Override
    public void entregarCarro(Carro carro) {
        System.out.println("O carro " + carro.getModelo() + " foi entregue ao cliente.");
    }
}