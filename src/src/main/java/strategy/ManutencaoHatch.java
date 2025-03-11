package strategy;

import abstractFactory.FabricaPeças;
import composite.KitCarro;
import composite.Peça;
import factoryMethod.Carro;

public class ManutencaoHatch implements EstrategiaManutencao {
    @Override
    public String realizarManutencao(Carro carro, FabricaPeças fabricaPeças) {
        StringBuilder resultado = new StringBuilder();
        resultado.append(verificarAerodinamica()).append("\n");
        resultado.append(trocarOleo()).append("\n");
        KitCarro kit = montarKitPeças(fabricaPeças);
        resultado.append(executarEtapaEspecifica(kit)).append("\n");
        resultado.append("Kit adicionado ao carro ").append(carro.getModelo()).append(":\n").append(kit.descricao());
        return resultado.toString();
    }

    private String verificarAerodinamica() {
        return "Verificando aerodinâmica...";
    }

    private String trocarOleo() {
        return "Trocando óleo...";
    }

    private KitCarro montarKitPeças(FabricaPeças fabricaPeças) {
        KitCarro kit = new KitCarro();
        kit.adicionar(fabricaPeças.createMotor());
        kit.adicionar(fabricaPeças.createPneu());
        return kit;
    }

    private String executarEtapaEspecifica(KitCarro kit) {
        kit.adicionar(new Peça("Aerofólio Esportivo", 2000.0));
        return "Etapa específica para Hatch: Aerofólio Esportivo adicionado.";
    }
}

