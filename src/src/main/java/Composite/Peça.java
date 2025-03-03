package Composite;

public class Peça implements ComponenteCarro {
    private String nome;

    public Peça(String nome) {
        this.nome = nome;
    }

    @Override
    public String descricao() {
        return "Peça: " + nome;
    }
}