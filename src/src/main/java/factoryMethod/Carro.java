package factoryMethod;

public abstract class Carro {
    private String modelo;
    private double preco;
    private boolean emManutencao;

    public Carro(String modelo, double preco) {
        this.modelo = modelo;
        this.preco = preco;
        this.emManutencao = false; // Por padrão, o carro não está em manutenção
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isEmManutencao() {
        return emManutencao;
    }

    public void setEmManutencao(boolean emManutencao) {
        this.emManutencao = emManutencao;
    }

    public String descricao() {
        return "Carro: " + modelo + ", Preço: " + preco;
    }
}