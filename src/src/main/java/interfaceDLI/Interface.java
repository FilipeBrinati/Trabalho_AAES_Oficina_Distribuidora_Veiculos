package interfaceDLI;

import java.util.Scanner;
import factoryMethod.*;
import observer.Cliente;
import singleton.EstoqueCarros;
import mediator.MediatorLojaOficina;
import abstractFactory.FabricaPeças;
import abstractFactory.FabricaPeçasSedan;
import abstractFactory.FabricaPeçasSUV;
import decorator.BancosCouroDecorator;
import decorator.SistemaSomPremiumDecorator;
import strategy.EstrategiaManutencao;
import strategy.ManutencaoSedan;
import strategy.ManutencaoSUV;

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
                    int tipoCarro = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    Carro carro = null;
                    if (tipoCarro == 1) {
                        carro = new SedanFactory().criarCarro();
                    } else if (tipoCarro == 2) {
                        carro = new SUVFactory().criarCarro();
                    } else {
                        System.out.println("Opção inválida!");
                        break;
                    }

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
                    break;

                case 3:
                    System.out.print("Digite o modelo do carro para manutenção (Sedan/SUV): ");
                    String modeloManutencao = scanner.nextLine();
                    Carro carroManutencao = modeloManutencao.equalsIgnoreCase("Sedan") ? new Sedan() : new SUV();
                    mediator.enviarParaManutencao(carroManutencao);
                    System.out.println("Carro enviado para manutenção!");
                    break;

                case 4:
                    System.out.print("Digite o modelo do carro para finalizar manutenção (Sedan/SUV): ");
                    String modeloFinalizar = scanner.nextLine();
                    Carro carroFinalizar = modeloFinalizar.equalsIgnoreCase("Sedan") ? new Sedan() : new SUV();
                    mediator.finalizarManutencao(carroFinalizar);
                    System.out.println("Manutenção finalizada!");
                    break;

                case 5:
                    System.out.print("Digite o modelo do carro para adicionar acessórios (Sedan/SUV): ");
                    String modeloAcessorio = scanner.nextLine();
                    Carro carroAcessorio = modeloAcessorio.equalsIgnoreCase("Sedan") ? new Sedan() : new SUV();

                    System.out.println("Escolha o acessório:");
                    System.out.println("1. Bancos de Couro");
                    System.out.println("2. Sistema de Som Premium");
                    int acessorio = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    if (acessorio == 1) {
                        carroAcessorio = new BancosCouroDecorator(carroAcessorio);
                    } else if (acessorio == 2) {
                        carroAcessorio = new SistemaSomPremiumDecorator(carroAcessorio);
                    } else {
                        System.out.println("Opção inválida!");
                        break;
                    }

                    System.out.println("Acessório adicionado: " + carroAcessorio.descricao());
                    break;

                case 6:
                    System.out.print("Digite o modelo do carro para manutenção (Sedan/SUV): ");
                    String modeloManutencaoEstrategia = scanner.nextLine();
                    Carro carroManutencaoEstrategia = modeloManutencaoEstrategia.equalsIgnoreCase("Sedan") ? new Sedan() : new SUV();

                    FabricaPeças fabrica = modeloManutencaoEstrategia.equalsIgnoreCase("Sedan") ? new FabricaPeçasSedan() : new FabricaPeçasSUV();
                    EstrategiaManutencao estrategia = modeloManutencaoEstrategia.equalsIgnoreCase("Sedan") ? new ManutencaoSedan() : new ManutencaoSUV();

                    System.out.println(estrategia.realizarManutencao(carroManutencaoEstrategia, fabrica));
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