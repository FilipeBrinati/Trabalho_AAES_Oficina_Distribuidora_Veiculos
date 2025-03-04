package mediator;

import java.util.ArrayList;
import java.util.List;

import factoryMethod.Carro;
import observer.Cliente;
import singleton.EstoqueCarros;
import state.EstadoCarro;
import state.ProntoParaEntrega;

public class MediatorLojaOficina {
    private EstoqueCarros estoqueCarros;
    private List<Cliente> clientes;

    public MediatorLojaOficina(EstoqueCarros estoqueCarros) {
        this.estoqueCarros = estoqueCarros;
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void venderCarro(Carro carro) {
        estoqueCarros.adicionarCarro(carro);
        notificarClientes("Novo carro disponível: " + carro.getModelo());
    }

    public void enviarParaManutencao(Carro carro) {
        estoqueCarros.adicionarCarroEmManutencao(carro);
        notificarClientes("O carro " + carro.getModelo() + " foi enviado para manutenção.");
    }

    public void finalizarManutencao(Carro carro) {
        estoqueCarros.removerCarroEmManutencao(carro);
        EstadoCarro estadoPronto = new ProntoParaEntrega();
        estadoPronto.entregarCarro(carro);
        notificarClientes("O carro " + carro.getModelo() + " está pronto para entrega.");
    }

    private void notificarClientes(String mensagem) {
        for (Cliente cliente : clientes) {
            cliente.atualizar(mensagem);
        }
    }
}