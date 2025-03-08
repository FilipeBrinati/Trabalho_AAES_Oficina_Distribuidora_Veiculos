package observer;

import factoryMethod.Carro;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;
    private List<Carro> carros;

    public Cliente(String nome) {
        this.nome = nome;
        this.carros = new ArrayList<>();
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void adicionarCarro(Carro carro) {
        this.carros.add(carro);
    }

    public List<Carro> getCarros() {
        return this.carros;
    }

    @Override
    public void update(Observable observable, Object arg) {
        this.ultimaNotificacao = this.nome + " recebeu a notificação: " + arg;
    }
}