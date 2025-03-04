package factoryMethod;


public abstract class Carro {
    private String modelo;
    private double preco;

    public Carro(String modelo, double preco) {
        this.modelo = modelo;
        this.preco = preco;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    public String descricao() {
        return "Carro: " + modelo + ", Preço: " + preco;
    }
}