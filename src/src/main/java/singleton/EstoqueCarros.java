package singleton;

import java.util.ArrayList;
import java.util.List;

import factoryMethod.Carro;

public class EstoqueCarros {
    private static EstoqueCarros instance;
    private List<Carro> carros;
    private List<Carro> carrosEmManutencao;

    private EstoqueCarros() {
        carros = new ArrayList<>();
        carrosEmManutencao = new ArrayList<>();
    }

    public static EstoqueCarros getInstance() {
        if (instance == null) {
            instance = new EstoqueCarros();
        }
        return instance;
    }

    public String adicionarCarro(Carro carro) {
        carros.add(carro);
        return "Carro " + carro.getModelo() + " adicionado ao estoque.";
    }

    public String adicionarCarroEmManutencao(Carro carro) {
        carrosEmManutencao.add(carro);
        return "Carro " + carro.getModelo() + " enviado para manutenção.";
    }

    public String removerCarroEmManutencao(Carro carro) {
        carrosEmManutencao.remove(carro);
        return "Carro " + carro.getModelo() + " pronto para entrega.";
    }

    public List<Carro> getCarrosProntosParaEntrega() {
        return carros;
    }

    public List<Carro> getCarrosEmManutencao() {
        return carrosEmManutencao;
    }
}