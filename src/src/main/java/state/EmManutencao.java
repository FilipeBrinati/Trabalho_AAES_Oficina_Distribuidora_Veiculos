package state;

import singleton.EstoqueCarros;
import factoryMethod.Carro;

public class EmManutencao implements EstadoCarro {
    @Override
    public void realizarManutencao(Carro carro) {
        System.out.println("O carro " + carro.getModelo() + " já está em manutenção.");
    }

    @Override
    public void entregarCarro(Carro carro) {
        EstoqueCarros.getInstance().removerCarroEmManutencao(carro);
        System.out.println("O carro " + carro.getModelo() + " está pronto para entrega.");
    }
}
