package Composite;

import java.util.ArrayList;
import java.util.List;

public class KitCarro implements ComponenteCarro {
    private List<ComponenteCarro> componentes = new ArrayList<>();

    public void adicionar(ComponenteCarro componente) {
        componentes.add(componente);
    }

    @Override
    public String descricao() {
        StringBuilder descricao = new StringBuilder("Kit do Carro:\n");
        for (ComponenteCarro componente : componentes) {
            descricao.append(componente.descricao()).append("\n");
        }
        return descricao.toString();
    }
}