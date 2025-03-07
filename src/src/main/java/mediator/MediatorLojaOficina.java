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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String venderCarro(Carro carro) {
        estoqueCarros.adicionarCarro(carro);
        return notificarClientes("Novo carro disponível: " + carro.getModelo());
    }

    public String enviarParaManutencao(Carro carro) {
        estoqueCarros.adicionarCarroEmManutencao(carro);
        return notificarClientes("O carro " + carro.getModelo() + " foi enviado para manutenção.");
    }

    public String finalizarManutencao(Carro carro) {
        estoqueCarros.removerCarroEmManutencao(carro);
        EstadoCarro estadoPronto = new ProntoParaEntrega();
        estadoPronto.entregarCarro(carro);
        return notificarClientes("O carro " + carro.getModelo() + " está pronto para entrega.");
    }

    private String notificarClientes(String mensagem) {
        StringBuilder notificacoes = new StringBuilder();
        for (Cliente cliente : clientes) {
            notificacoes.append(cliente.atualizar(mensagem)).append("\n");
        }
        return notificacoes.toString();
    }
}
