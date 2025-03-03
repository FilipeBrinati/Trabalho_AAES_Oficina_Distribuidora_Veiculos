package strategy;

public class ManutencaoSedan implements EstrategiaManutencao {
    @Override
    public void realizarManutencao() {
        System.out.println("Realizando manutenção específica para Sedan.");
    }
}
