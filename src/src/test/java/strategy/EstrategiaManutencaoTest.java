package strategy;

import org.junit.jupiter.api.Test;

import factoryMethod.Carro;
import factoryMethod.SUVFactory;
import factoryMethod.SedanFactory;
import abstractFactory.FabricaPeças;
import abstractFactory.FabricaPeçasSedan;
import abstractFactory.FabricaPeçasSUV;

import static org.junit.jupiter.api.Assertions.*;

class EstrategiaManutencaoTest {
    @Test
    void testManutencaoSedan() {
        Carro carro = new SedanFactory().criarCarro();
        FabricaPeças fabricaPeças = new FabricaPeçasSedan();
        EstrategiaManutencao estrategia = new ManutencaoSedan();

        String resultado = estrategia.realizarManutencao(carro, fabricaPeças);

        assertTrue(resultado.contains("Verificando freios..."));
        assertTrue(resultado.contains("Trocando óleo..."));
        assertTrue(resultado.contains("Etapa específica para Sedan: Suspensão Esportiva adicionada."));
        assertTrue(resultado.contains("Kit adicionado ao carro Sedan:"));
        assertTrue(resultado.contains("Peça: Motor Sedan"));
        assertTrue(resultado.contains("Peça: Pneu Sedan"));
        assertTrue(resultado.contains("Peça: Suspensão Esportiva"));
    }

    @Test
    void testManutencaoSUV() {
        Carro carro = new SUVFactory().criarCarro();
        FabricaPeças fabricaPeças = new FabricaPeçasSUV();
        EstrategiaManutencao estrategia = new ManutencaoSUV();

        String resultado = estrategia.realizarManutencao(carro, fabricaPeças);

        assertTrue(resultado.contains("Verificando freios..."));
        assertTrue(resultado.contains("Trocando óleo..."));
        assertTrue(resultado.contains("Etapa específica para SUV: Tração 4x4 adicionada."));
        assertTrue(resultado.contains("Kit adicionado ao carro SUV:"));
        assertTrue(resultado.contains("Peça: Motor SUV"));
        assertTrue(resultado.contains("Peça: Pneu SUV"));
        assertTrue(resultado.contains("Peça: Tração 4x4"));
    }
}