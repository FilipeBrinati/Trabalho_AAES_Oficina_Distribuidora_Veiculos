package templateMethod;

import composite.KitCarro;
import composite.Peça;
import factoryMethod.Carro;

public abstract class ProcessoManutencao {
    public final void realizarManutencao(Carro carro) {
        verificarFreios();
        trocarOleo();
        KitCarro kit = new KitCarro();
        kit.adicionar(new Peça("Motor", 5000.0));
        kit.adicionar(new Peça("Pneus", 2000.0));
        etapaEspecifica(kit);
        System.out.println("Kit adicionado ao carro: " + kit.descricao());
    }

    protected abstract void etapaEspecifica(KitCarro kit);

    private void verificarFreios() {
        System.out.println("Verificando freios...");
    }

    private void trocarOleo() {
        System.out.println("Trocando óleo...");
    }
}