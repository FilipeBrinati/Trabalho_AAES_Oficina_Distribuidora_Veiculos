package mediator;

import singleton.EstoqueCarros;
import observer.Cliente;
import java.util.ArrayList;
import java.util.List;
import factoryMethod.Carro;

public class MediatorLojaOficina {
    private EstoqueCarros estoqueCarros;
    private List<Cliente> clientes;

    public MediatorLojaOficina(EstoqueCarros estoqueCarros) {
        this.estoqueCarros = estoqueCarros;
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        estoqueCarros.addObserver(cliente); // Adiciona o cliente como observador
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String venderCarro(Carro carro, Cliente cliente) {
        String resultado = estoqueCarros.adicionarCarro(carro);
        cliente.adicionarCarro(carro); // Associa o carro ao cliente
        return resultado;
    }

    public String enviarParaManutencao(Carro carro) {
        return estoqueCarros.adicionarCarroEmManutencao(carro);
    }

    public String finalizarManutencao(Carro carro) {
        return estoqueCarros.removerCarroEmManutencao(carro);
    }
}