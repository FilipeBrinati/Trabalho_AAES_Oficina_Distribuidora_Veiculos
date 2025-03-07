package observer;

public class Cliente implements Observer {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public String atualizar(String mensagem) {
        return nome + " recebeu a notificação: " + mensagem;
    }
}