package factoryMethod;

import state.EstadoCarro;
import state.ProntoParaEntrega;

public abstract class Carro {
    private String modelo;
    private double preco;
    private boolean emManutencao;
    private EstadoCarro estado;

    public Carro(String modelo, double preco) {
        this.modelo = modelo;
        this.preco = preco;
        this.emManutencao = false;
        this.estado = new ProntoParaEntrega(); // Estado inicial
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

    public EstadoCarro getEstado() {
        return estado;
    }

    public void setEstado(EstadoCarro estado) {
        this.estado = estado;
    }

    public String avancarEstado() {
        return estado.avancar(this);
    }

    public String descricao() {
        return "Carro: " + modelo + ", Preço: " + preco;
    }
}