package TemplateMethod;

public class ManutencaoSUVProcesso extends ProcessoManutencao {
    @Override
    protected void etapaEspecifica() {
        System.out.println("Realizando etapa específica para SUV.");
    }
}