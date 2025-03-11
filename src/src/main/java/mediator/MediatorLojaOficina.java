package mediator;

import singleton.EstoqueCarros;
import observer.Cliente;
import factoryMethod.Carro;

import java.util.ArrayList;
import java.util.List;

public class MediatorLojaOficina {
    private EstoqueCarros estoqueCarros;
    private List<Cliente> clientes;

    public MediatorLojaOficina(EstoqueCarros estoqueCarros) {
        this.estoqueCarros = estoqueCarros;
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        estoqueCarros.addObserver(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String venderCarro(Carro carro, Cliente cliente) {
        String resultado = estoqueCarros.adicionarCarro(carro);
        if (cliente != null) {
            cliente.adicionarCarro(carro);
        }
        return resultado;
    }

    public String enviarParaManutencao(Carro carro) {
        carro.setEmManutencao(true);
        return estoqueCarros.adicionarCarroEmManutencao(carro);
    }

    public String finalizarManutencao(Carro carro) {
        carro.setEmManutencao(false);
        return estoqueCarros.removerCarroEmManutencao(carro);
    }
}