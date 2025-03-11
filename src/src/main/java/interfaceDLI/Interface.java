package interfaceDLI;

import java.util.Scanner;
import factoryMethod.*;
import observer.Cliente;
import singleton.EstoqueCarros;
import mediator.MediatorLojaOficina;
import abstractFactory.FabricaPeças;
import abstractFactory.FabricaPeçasSedan;
import abstractFactory.FabricaPeçasSUV;
import abstractFactory.FabricaPeçasHatch;
import abstractFactory.FabricaPeçasPickup;
import abstractFactory.FabricaPeçasCaminhão;
import decorator.BancosCouroDecorator;
import decorator.SistemaSomPremiumDecorator;
import decorator.TetoSolarDecorator;
import decorator.RodasEsportivasDecorator;
import decorator.PinturaEspecialDecorator;
import strategy.EstrategiaManutencao;
import strategy.ManutencaoSedan;
import strategy.ManutencaoSUV;
import strategy.ManutencaoHatch;
import strategy.ManutencaoPickup;
import strategy.ManutencaoCaminhão;

public class Interface {
    public static void main(String[] args) {
        EstoqueCarros estoque = EstoqueCarros.getInstance();
        MediatorLojaOficina mediator = new MediatorLojaOficina(estoque);
        Scanner scanner = new Scanner(System.in);

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

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente);
                    mediator.adicionarCliente(cliente);
                    System.out.println("Cliente " + nomeCliente + " adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("Escolha o tipo de carro:");
                    System.out.println("1. Sedan");
                    System.out.println("2. SUV");
                    System.out.println("3. Hatch");
                    System.out.println("4. Pickup");
                    System.out.println("5. Caminhão");
                    int tipoCarro = scanner.nextInt();
                    scanner.nextLine(); 

                    Carro carro = null;
                    switch (tipoCarro) {
                        case 1:
                            carro = new SedanFactory().criarCarro();
                            break;
                        case 2:
                            carro = new SUVFactory().criarCarro();
                            break;
                        case 3:
                            carro = new HatchFactory().criarCarro();
                            break;
                        case 4:
                            carro = new PickupFactory().criarCarro();
                            break;
                        case 5:
                            carro = new CaminhãoFactory().criarCarro();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }

                    if (carro != null) {
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
                    }
                    break;

                case 3:
                    System.out.print("Digite o modelo do carro para manutenção (Sedan/SUV/Hatch/Pickup/Caminhão): ");
                    String modeloManutencao = scanner.nextLine();
                    Carro carroManutencao = null;
                    switch (modeloManutencao.toLowerCase()) {
                        case "sedan":
                            carroManutencao = new Sedan();
                            break;
                        case "suv":
                            carroManutencao = new SUV();
                            break;
                        case "hatch":
                            carroManutencao = new Hatch();
                            break;
                        case "pickup":
                            carroManutencao = new Pickup();
                            break;
                        case "caminhão":
                            carroManutencao = new Caminhão();
                            break;
                        default:
                            System.out.println("Modelo inválido!");
                            break;
                    }

                    if (carroManutencao != null) {
                        String mensagem = mediator.enviarParaManutencao(carroManutencao);
                        System.out.println(mensagem);
                    }
                    break;

                case 4:
                    System.out.print("Digite o modelo do carro para finalizar manutenção (Sedan/SUV/Hatch/Pickup/Caminhão): ");
                    String modeloFinalizar = scanner.nextLine();
                    Carro carroFinalizar = null;
                    switch (modeloFinalizar.toLowerCase()) {
                        case "sedan":
                            carroFinalizar = new Sedan();
                            break;
                        case "suv":
                            carroFinalizar = new SUV();
                            break;
                        case "hatch":
                            carroFinalizar = new Hatch();
                            break;
                        case "pickup":
                            carroFinalizar = new Pickup();
                            break;
                        case "caminhão":
                            carroFinalizar = new Caminhão();
                            break;
                        default:
                            System.out.println("Modelo inválido!");
                            break;
                    }

                    if (carroFinalizar != null) {
                        String mensagem = mediator.finalizarManutencao(carroFinalizar);
                        System.out.println(mensagem);
                    }
                    break;

                case 5:
                    System.out.print("Digite o modelo do carro para adicionar acessórios (Sedan/SUV/Hatch/Pickup/Caminhão): ");
                    String modeloAcessorio = scanner.nextLine();
                    Carro carroAcessorio = null;
                    switch (modeloAcessorio.toLowerCase()) {
                        case "sedan":
                            carroAcessorio = new Sedan();
                            break;
                        case "suv":
                            carroAcessorio = new SUV();
                            break;
                        case "hatch":
                            carroAcessorio = new Hatch();
                            break;
                        case "pickup":
                            carroAcessorio = new Pickup();
                            break;
                        case "caminhão":
                            carroAcessorio = new Caminhão();
                            break;
                        default:
                            System.out.println("Modelo inválido!");
                            break;
                    }

                    if (carroAcessorio != null) {
                        if (carroAcessorio.isEmManutencao()) {
                            System.out.println("Escolha o acessório:");
                            System.out.println("1. Bancos de Couro");
                            System.out.println("2. Sistema de Som Premium");
                            System.out.println("3. Teto Solar");
                            System.out.println("4. Rodas Esportivas");
                            System.out.println("5. Pintura Especial");
                            int acessorio = scanner.nextInt();
                            scanner.nextLine(); 

                            switch (acessorio) {
                                case 1:
                                    carroAcessorio = new BancosCouroDecorator(carroAcessorio);
                                    break;
                                case 2:
                                    carroAcessorio = new SistemaSomPremiumDecorator(carroAcessorio);
                                    break;
                                case 3:
                                    carroAcessorio = new TetoSolarDecorator(carroAcessorio);
                                    break;
                                case 4:
                                    carroAcessorio = new RodasEsportivasDecorator(carroAcessorio);
                                    break;
                                case 5:
                                    carroAcessorio = new PinturaEspecialDecorator(carroAcessorio);
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                            System.out.println("Acessório adicionado: " + carroAcessorio.descricao());
                        } else {
                            System.out.println("O carro não está em manutenção. Personalização não permitida.");
                        }
                    }
                    break;

                case 6:
                    System.out.print("Digite o modelo do carro para manutenção (Sedan/SUV/Hatch/Pickup/Caminhão): ");
                    String modeloManutencaoEstrategia = scanner.nextLine();
                    Carro carroManutencaoEstrategia = null;
                    FabricaPeças fabricaManutencao = null;
                    EstrategiaManutencao estrategia = null;

                    switch (modeloManutencaoEstrategia.toLowerCase()) {
                        case "sedan":
                            carroManutencaoEstrategia = new Sedan();
                            fabricaManutencao = new FabricaPeçasSedan();
                            estrategia = new ManutencaoSedan();
                            break;
                        case "suv":
                            carroManutencaoEstrategia = new SUV();
                            fabricaManutencao = new FabricaPeçasSUV();
                            estrategia = new ManutencaoSUV();
                            break;
                        case "hatch":
                            carroManutencaoEstrategia = new Hatch();
                            fabricaManutencao = new FabricaPeçasHatch();
                            estrategia = new ManutencaoHatch();
                            break;
                        case "pickup":
                            carroManutencaoEstrategia = new Pickup();
                            fabricaManutencao = new FabricaPeçasPickup();
                            estrategia = new ManutencaoPickup();
                            break;
                        case "caminhão":
                            carroManutencaoEstrategia = new Caminhão();
                            fabricaManutencao = new FabricaPeçasCaminhão();
                            estrategia = new ManutencaoCaminhão();
                            break;
                        default:
                            System.out.println("Modelo inválido!");
                            break;
                    }

                    if (carroManutencaoEstrategia != null) {
                        System.out.println(estrategia.realizarManutencao(carroManutencaoEstrategia, fabricaManutencao));
                    }
                    break;

                case 7:
                    System.out.println("Carros prontos para entrega:");
                    for (Carro c : estoque.getCarrosProntosParaEntrega()) {
                        System.out.println(c.descricao());
                    }
                    break;

                case 8:
                    System.out.println("Carros em manutenção:");
                    for (Carro c : estoque.getCarrosEmManutencao()) {
                        System.out.println(c.descricao());
                    }
                    break;

                case 9:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}