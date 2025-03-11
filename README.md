# Trabalho_AAES_Oficina_Distribuidora_Veiculos
 
Este projeto é um sistema de gerenciamento para uma loja/oficina de veículos, desenvolvido em Java. Ele permite gerenciar clientes, veículos, vendas, manutenções e personalizações de carros, utilizando vários padrões de projeto para garantir modularidade, flexibilidade e escalabilidade.

# Funcionalidades Principais
Cadastro de Clientes:

Adicionar novos clientes ao sistema.

Associar clientes a veículos vendidos.

Venda de Veículos:

Vender carros de diferentes tipos (Sedan, SUV, Hatch, Pickup, Caminhão).

Associar veículos a clientes (opcional).

Manutenção de Veículos:

Enviar veículos para manutenção.

Finalizar manutenções e marcar veículos como prontos para entrega.

Personalização de Veículos:

Adicionar acessórios a veículos em manutenção (Bancos de Couro, Sistema de Som Premium, Teto Solar, Rodas Esportivas, Pintura Especial).

Estratégias de Manutenção:

Realizar manutenções específicas para cada tipo de veículo, utilizando peças apropriadas.

Notificações:

Notificar clientes sobre mudanças no estado dos veículos (em manutenção, pronto para entrega).

# Padrões de Projeto Utilizados
O projeto utiliza os seguintes padrões de projeto para garantir uma arquitetura limpa e modular:

Singleton:

Garante que apenas uma instância do estoque de carros (EstoqueCarros) exista no sistema.

Abstract Factory:

Cria famílias de peças específicas para cada tipo de veículo (FabricaPeçasSedan, FabricaPeçasSUV, etc.).

Factory Method:

Cria instâncias de veículos (SedanFactory, SUVFactory, etc.).

Decorator:

Adiciona funcionalidades dinamicamente aos veículos (acessórios como Bancos de Couro, Sistema de Som Premium, etc.).

State:

Gerencia o estado dos veículos (EmManutencao, ProntoParaEntrega).

Observer:

Notifica clientes sobre mudanças no estado dos veículos.

Strategy:

Define estratégias de manutenção específicas para cada tipo de veículo (ManutencaoSedan, ManutencaoSUV, etc.).

Mediator:

Centraliza a comunicação entre os componentes do sistema (estoque, clientes, veículos).

Composite:

Permite tratar peças individuais e kits de peças de forma uniforme.

# Tecnologias e Ferramentas
Linguagem: Java 8

Gerenciamento de Dependências: Maven

Testes: JUnit 5

IDE: Eclipse (ou qualquer IDE compatível com Java e Maven)
