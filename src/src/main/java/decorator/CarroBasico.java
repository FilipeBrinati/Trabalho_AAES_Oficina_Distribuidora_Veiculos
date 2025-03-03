package decorator;

public class CarroBasico implements Carro {
    @Override
    public String descricao() {
        return "Carro Básico";
    }

    @Override
    public double getPreco() {
        return 30000.0;
    }
}