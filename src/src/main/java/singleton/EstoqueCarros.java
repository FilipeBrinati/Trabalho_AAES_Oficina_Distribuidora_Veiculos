package singleton;

import factoryMethod.Carro;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class EstoqueCarros extends Observable {
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
        setChanged(); // Marca que houve uma mudança
        notifyObservers("Novo carro disponível: " + carro.getModelo()); // Notifica os observadores
        return "Carro " + carro.getModelo() + " adicionado ao estoque.";
    }

    public String adicionarCarroEmManutencao(Carro carro) {
        carrosEmManutencao.add(carro);
        setChanged(); // Marca que houve uma mudança
        notifyObservers("O carro " + carro.getModelo() + " foi enviado para manutenção."); // Notifica os observadores
        return "Carro " + carro.getModelo() + " enviado para manutenção.";
    }

    public String removerCarroEmManutencao(Carro carro) {
        carrosEmManutencao.remove(carro);
        setChanged(); // Marca que houve uma mudança
        notifyObservers("O carro " + carro.getModelo() + " está pronto para entrega."); // Notifica os observadores
        return "Carro " + carro.getModelo() + " pronto para entrega.";
    }

    public List<Carro> getCarrosProntosParaEntrega() {
        return carros;
    }

    public List<Carro> getCarrosEmManutencao() {
        return carrosEmManutencao;
    }
}