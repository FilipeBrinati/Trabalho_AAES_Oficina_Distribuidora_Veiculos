package strategy;

public class ManutencaoSUV implements EstrategiaManutencao {
    @Override
    public void realizarManutencao() {
        System.out.println("Realizando manutenção específica para SUV.");
    }
}