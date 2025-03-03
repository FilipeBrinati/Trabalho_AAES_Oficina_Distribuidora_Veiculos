package templateMethod;

import composite.KitCarro;

public class ManutencaoSUVProcesso extends ProcessoManutencao {
    protected void etapaEspecifica() {
        System.out.println("Realizando etapa específica para SUV.");
    }

	@Override
	protected void etapaEspecifica(KitCarro kit) {
		// TODO Auto-generated method stub
		
	}
}