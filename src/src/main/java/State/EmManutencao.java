package State;

public class EmManutencao implements EstadoCarro {
    @Override
    public void realizarManutencao() {
        System.out.println("O carro já está em manutenção.");
    }

    @Override
    public void entregarCarro() {
        System.out.println("O carro está pronto para entrega.");
    }
}