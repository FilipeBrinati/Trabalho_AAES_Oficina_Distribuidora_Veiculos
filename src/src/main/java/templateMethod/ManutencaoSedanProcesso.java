package templateMethod;

import composite.KitCarro;

public class ManutencaoSedanProcesso extends ProcessoManutencao {
    protected void etapaEspecifica() {
        System.out.println("Realizando etapa específica para Sedan.");
    }

	@Override
	protected void etapaEspecifica(KitCarro kit) {
		// TODO Auto-generated method stub
		
	}
}