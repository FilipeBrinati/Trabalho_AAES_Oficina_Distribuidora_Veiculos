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

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    public void adicionarCarroEmManutencao(Carro carro) {
        carrosEmManutencao.add(carro);
    }

    public void removerCarroEmManutencao(Carro carro) {
        carrosEmManutencao.remove(carro);
    }

    public List<Carro> getCarrosEmManutencao() {
        return carrosEmManutencao;
    }

    public List<Carro> getCarrosProntosParaEntrega() {
        return carros;
    }
}