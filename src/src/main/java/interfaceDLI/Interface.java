package interfaceDLI;

import java.util.*;

import abstractFactory.FabricaPeças;
import abstractFactory.FabricaPeçasCaminhão;
import abstractFactory.FabricaPeçasHatch;
import abstractFactory.FabricaPeçasPickup;
import abstractFactory.FabricaPeçasSUV;
import abstractFactory.FabricaPeçasSedan;
import decorator.BancosCouroDecorator;
import decorator.CarroDecorator;
import decorator.PinturaEspecialDecorator;
import decorator.RodasEsportivasDecorator;
import decorator.SistemaSomPremiumDecorator;
import decorator.TetoSolarDecorator;
import factoryMethod.CaminhãoFactory;
import factoryMethod.Carro;
import factoryMethod.CarroFactory;
import factoryMethod.HatchFactory;
import factoryMethod.PickupFactory;
import factoryMethod.SUVFactory;
import factoryMethod.SedanFactory;
import mediator.MediatorLojaOficina;
import observer.Cliente;
import singleton.EstoqueCarros;
import strategy.EstrategiaManutencao;
import strategy.ManutencaoCaminhão;
import strategy.ManutencaoHatch;
import strategy.ManutencaoPickup;
import strategy.ManutencaoSUV;
import strategy.ManutencaoSedan;

public class Interface {
    private static final Map<String, CarroFactory> fabricas = new HashMap<>();
    private static final Map<String, FabricaPeças> fabricasPeças = new HashMap<>();
    private static final Map<String, EstrategiaManutencao> estrategiasManutencao = new HashMap<>();

    static {
        // Mapeamento de modelos para fábricas de carros
        fabricas.put("sedan", new SedanFactory());
        fabricas.put("suv", new SUVFactory());
        fabricas.put("hatch", new HatchFactory());
        fabricas.put("pickup", new PickupFactory());
        fabricas.put("caminhão", new CaminhãoFactory());

        // Mapeamento de modelos para fábricas de peças
        fabricasPeças.put("sedan", new FabricaPeçasSedan());
        fabricasPeças.put("suv", new FabricaPeçasSUV());
        fabricasPeças.put("hatch", new FabricaPeçasHatch());
        fabricasPeças.put("pickup", new FabricaPeçasPickup());
        fabricasPeças.put("caminhão", new FabricaPeçasCaminhão());

        // Mapeamento de modelos para estratégias de manutenção
        estrategiasManutencao.put("sedan", new ManutencaoSedan());
        estrategiasManutencao.put("suv", new ManutencaoSUV());
        estrategiasManutencao.put("hatch", new ManutencaoHatch());
        estrategiasManutencao.put("pickup", new ManutencaoPickup());
        estrategiasManutencao.put("caminhão", new ManutencaoCaminhão());
    }

    public static void main(String[] args) {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        MediatorLojaOficina mediator = new MediatorLojaOficina(estoque);
        Scanner scanner = new Scanner(System.in);

        // Mapeamento de opções para funções
        Map<Integer, Runnable> opcoes = new HashMap<>();
        opcoes.put(1, () -> adicionarCliente(mediator, scanner));
        opcoes.put(2, () -> venderCarro(mediator, scanner));
        opcoes.put(3, () -> enviarParaManutencao(mediator, scanner));
        opcoes.put(4, () -> finalizarManutencao(mediator, scanner));
        opcoes.put(5, () -> adicionarAcessorios(mediator, scanner));
        opcoes.put(6, () -> realizarManutencao(mediator, scanner));
        opcoes.put(7, () -> listarCarrosProntos(estoque));
        opcoes.put(8, () -> listarCarrosEmManutencao(estoque));
        opcoes.put(9, () -> System.exit(0));

        while (true) {
            System.out.println("\n--- Loja/Oficina de Veículos ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Vender Carro");
            System.out.println("3. Enviar Carro para Manutenção");
            System.out.println("4. Finalizar Manutenção");
            System.out.println("5. Adicionar Acessórios ao Carro");
            System.out.println("6. Realizar Manutenção");
            System.out.println("7. Listar Carros Prontos para Entrega");
            System.out.println("8. Listar Carros em Manutenção");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            // Executa a função correspondente à opção escolhida
            Runnable acao = opcoes.get(opcao);
            if (acao != null) {
                acao.run();
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    // Métodos para cada funcionalidade
    private static void adicionarCliente(MediatorLojaOficina mediator, Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);
        mediator.adicionarCliente(cliente);
        System.out.println("Cliente " + nomeCliente + " adicionado com sucesso!");
    }

    private static void venderCarro(MediatorLojaOficina mediator, Scanner scanner) {
        System.out.println("Escolha o tipo de carro:");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. Hatch");
        System.out.println("4. Pickup");
        System.out.println("5. Caminhão");
        int tipoCarro = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        String[] modelos = {"sedan", "suv", "hatch", "pickup", "caminhão"};
        if (tipoCarro >= 1 && tipoCarro <= modelos.length) {
            String modelo = modelos[tipoCarro - 1];
            Carro carro = fabricas.get(modelo).criarCarro();
            System.out.print("Deseja associar o carro a um cliente? (s/n): ");
            String associarCliente = scanner.nextLine();
            if (associarCliente.equalsIgnoreCase("s")) {
                System.out.print("Digite o nome do cliente: ");
                String nomeClienteVenda = scanner.nextLine();
                Cliente clienteVenda = new Cliente(nomeClienteVenda);
                mediator.adicionarCliente(clienteVenda);
                mediator.venderCarro(carro, clienteVenda);
                System.out.println("Carro vendido para " + nomeClienteVenda + "!");
            } else {
                mediator.venderCarro(carro, null);
                System.out.println("Carro vendido sem associar a um cliente!");
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void enviarParaManutencao(MediatorLojaOficina mediator, Scanner scanner) {
        System.out.print("Digite o modelo do carro para manutenção (Sedan/SUV/Hatch/Pickup/Caminhão): ");
        String modelo = scanner.nextLine().toLowerCase();
        Carro carro = fabricas.get(modelo).criarCarro();
        if (carro != null) {
            String mensagem = mediator.enviarParaManutencao(carro);
            System.out.println(mensagem);
        } else {
            System.out.println("Modelo inválido!");
        }
    }

    private static void finalizarManutencao(MediatorLojaOficina mediator, Scanner scanner) {
        System.out.print("Digite o modelo do carro para finalizar manutenção (Sedan/SUV/Hatch/Pickup/Caminhão): ");
        String modelo = scanner.nextLine().toLowerCase();
        Carro carro = fabricas.get(modelo).criarCarro();
        if (carro != null) {
            String mensagem = mediator.finalizarManutencao(carro);
            System.out.println(mensagem);
        } else {
            System.out.println("Modelo inválido!");
        }
    }

    private static void adicionarAcessorios(MediatorLojaOficina mediator, Scanner scanner) {
        System.out.print("Digite o modelo do carro para adicionar acessórios (Sedan/SUV/Hatch/Pickup/Caminhão): ");
        String modelo = scanner.nextLine().toLowerCase();
        Carro carro = fabricas.get(modelo).criarCarro();
        if (carro != null && carro.isEmManutencao()) {
            System.out.println("Escolha o acessório:");
            System.out.println("1. Bancos de Couro");
            System.out.println("2. Sistema de Som Premium");
            System.out.println("3. Teto Solar");
            System.out.println("4. Rodas Esportivas");
            System.out.println("5. Pintura Especial");
            int acessorio = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            Map<Integer, CarroDecorator> decoradores = new HashMap<>();
            decoradores.put(1, new BancosCouroDecorator(carro));
            decoradores.put(2, new SistemaSomPremiumDecorator(carro));
            decoradores.put(3, new TetoSolarDecorator(carro));
            decoradores.put(4, new RodasEsportivasDecorator(carro));
            decoradores.put(5, new PinturaEspecialDecorator(carro));

            CarroDecorator decorador = decoradores.get(acessorio);
            if (decorador != null) {
                System.out.println("Acessório adicionado: " + decorador.descricao());
            } else {
                System.out.println("Opção inválida!");
            }
        } else {
            System.out.println("O carro não está em manutenção. Personalização não permitida.");
        }
    }

    private static void realizarManutencao(MediatorLojaOficina mediator, Scanner scanner) {
        System.out.print("Digite o modelo do carro para manutenção (Sedan/SUV/Hatch/Pickup/Caminhão): ");
        String modelo = scanner.nextLine().toLowerCase();
        Carro carro = fabricas.get(modelo).criarCarro();
        if (carro != null) {
            FabricaPeças fabrica = fabricasPeças.get(modelo);
            EstrategiaManutencao estrategia = estrategiasManutencao.get(modelo);
            if (fabrica != null && estrategia != null) {
                System.out.println(estrategia.realizarManutencao(carro, fabrica));
            }
        } else {
            System.out.println("Modelo inválido!");
        }
    }

    private static void listarCarrosProntos(EstoqueCarros estoque) {
        System.out.println("Carros prontos para entrega:");
        for (Carro c : estoque.getCarrosProntosParaEntrega()) {
            System.out.println(c.descricao());
        }
    }

    private static void listarCarrosEmManutencao(EstoqueCarros estoque) {
        System.out.println("Carros em manutenção:");
        for (Carro c : estoque.getCarrosEmManutencao()) {
            System.out.println(c.descricao());
        }
    }
}