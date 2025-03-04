package strategy;

import abstractFactory.FabricaPeças;
import composite.KitCarro;
import composite.Peça;
import factoryMethod.Carro;

public class ManutencaoSedan implements EstrategiaManutencao {
    @Override
    public void realizarManutencao(Carro carro, FabricaPeças fabricaPeças) {
        verificarFreios();
        trocarOleo();
        KitCarro kit = montarKitPeças(fabricaPeças);
        executarEtapaEspecifica(kit);
        System.out.println("Kit adicionado ao carro " + carro.getModelo() + ":\n" + kit.descricao());
    }

    private void verificarFreios() {
        System.out.println("Verificando freios...");
    }

    private void trocarOleo() {
        System.out.println("Trocando óleo...");
    }

    private KitCarro montarKitPeças(FabricaPeças fabricaPeças) {
        KitCarro kit = new KitCarro();
        kit.adicionar(fabricaPeças.createMotor());
        kit.adicionar(fabricaPeças.createPneu());
        return kit;
    }

    private void executarEtapaEspecifica(KitCarro kit) {
        kit.adicionar(new Peça("Suspensão Esportiva", 3000.0));
        System.out.println("Etapa específica para Sedan: Suspensão Esportiva adicionada.");
    }
}