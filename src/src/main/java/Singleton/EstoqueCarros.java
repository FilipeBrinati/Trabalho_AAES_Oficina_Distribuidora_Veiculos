package Singleton;

import FactoryMethod.Carro;
import java.util.ArrayList;
import java.util.List;

public class EstoqueCarros {
    private static EstoqueCarros instance;
    private List<Carro> carros;

    private EstoqueCarros() {
        carros = new ArrayList<>();
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

    public List<Carro> getCarros() {
        return carros;
    }
}