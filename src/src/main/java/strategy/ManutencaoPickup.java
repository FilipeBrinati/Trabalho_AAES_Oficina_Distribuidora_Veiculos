package strategy;

import abstractFactory.FabricaPeças;
import composite.KitCarro;
import composite.Peça;
import factoryMethod.Carro;

public class ManutencaoPickup implements EstrategiaManutencao {
    @Override
    public String realizarManutencao(Carro carro, FabricaPeças fabricaPeças) {
        StringBuilder resultado = new StringBuilder();
        resultado.append(verificarSuspensao()).append("\n");
        resultado.append(trocarOleo()).append("\n");
        KitCarro kit = montarKitPeças(fabricaPeças);
        resultado.append(executarEtapaEspecifica(kit)).append("\n");
        resultado.append("Kit adicionado ao carro ").append(carro.getModelo()).append(":\n").append(kit.descricao());
        return resultado.toString();
    }

    private String verificarSuspensao() {
        return "Verificando suspensão reforçada...";
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
        kit.adicionar(new Peça("Caçamba Reforçada", 5000.0));
        return "Etapa específica para Pickup: Caçamba Reforçada adicionada.";
    }
}