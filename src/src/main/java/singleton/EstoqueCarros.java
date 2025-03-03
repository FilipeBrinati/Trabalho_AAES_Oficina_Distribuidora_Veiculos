package singleton;

import observer.Observer;
import factoryMethod.Carro;
import java.util.ArrayList;
import java.util.List;


public class EstoqueCarros {
    private static EstoqueCarros instance;
    private List<Carro> carros;
    private List<Carro> carrosEmManutencao;
    private List<Observer> clientes;

    private EstoqueCarros() {
        carros = new ArrayList<>();
        carrosEmManutencao = new ArrayList<>();
        clientes = new ArrayList<>();
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
        notificarClientes("O carro " + carro.getModelo() + " está pronto para entrega.");
    }

    public void adicionarCliente(Observer cliente) {
        clientes.add(cliente);
    }

    public void notificarClientes(String mensagem) {
        for (Observer cliente : clientes) {
            cliente.atualizar(mensagem);
        }
    }

    public List<Carro> getCarrosEmManutencao() {
        return carrosEmManutencao;
    }

    public List<Carro> getCarrosProntosParaEntrega() {
        return carros;
    }
}
