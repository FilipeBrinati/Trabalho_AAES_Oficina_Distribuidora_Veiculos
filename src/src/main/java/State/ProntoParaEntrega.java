package State;

public class ProntoParaEntrega implements EstadoCarro {
    @Override
    public void realizarManutencao() {
        System.out.println("O carro precisa ser enviado para manutenção.");
    }

    @Override
    public void entregarCarro() {
        System.out.println("O carro foi entregue ao cliente.");
    }
}