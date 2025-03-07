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
        setChanged(); 
        notifyObservers("Novo carro disponível: " + carro.getModelo()); 
        return "Carro " + carro.getModelo() + " adicionado ao estoque.";
    }

    public String adicionarCarroEmManutencao(Carro carro) {
        carrosEmManutencao.add(carro);
        setChanged(); 
        notifyObservers("O carro " + carro.getModelo() + " foi enviado para manutenção."); 
        return "Carro " + carro.getModelo() + " enviado para manutenção.";
    }

    public String removerCarroEmManutencao(Carro carro) {
        carrosEmManutencao.remove(carro);
        setChanged(); 
        notifyObservers("O carro " + carro.getModelo() + " está pronto para entrega."); 
        return "Carro " + carro.getModelo() + " pronto para entrega.";
    }

    public List<Carro> getCarrosProntosParaEntrega() {
        return carros;
    }

    public List<Carro> getCarrosEmManutencao() {
        return carrosEmManutencao;
    }
}