package TemplateMethod;

public class ManutencaoSedanProcesso extends ProcessoManutencao {
    @Override
    protected void etapaEspecifica() {
        System.out.println("Realizando etapa específica para Sedan.");
    }
}