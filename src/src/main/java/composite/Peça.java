package composite;

public class Peça implements ComponenteCarro {
    private String nome;
    private double preco;

    public Peça(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String descricao() {
        return "Peça: " + nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
