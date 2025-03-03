package abstractFactory;

public class SistemaEletrico {
    private String tipo;

    public SistemaEletrico(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}