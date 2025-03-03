package TemplateMethod;

public abstract class ProcessoManutencao {
    public final void realizarManutencao() {
        verificarFreios();
        trocarOleo();
        etapaEspecifica();
    }

    protected abstract void etapaEspecifica();

    private void verificarFreios() {
        System.out.println("Verificando freios...");
    }

    private void trocarOleo() {
        System.out.println("Trocando óleo...");
    }
}