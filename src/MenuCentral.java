package src;

import java.util.Scanner;

public class MenuCentral {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CentralAtendimento central = new CentralAtendimento();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========================================");
            System.out.println("   CENTRAL DE ATENDIMENTO");
            System.out.println("========================================");
            System.out.println("1. Abrir novo processo");
            System.out.println("2. Atender próximo processo");
            System.out.println("3. Desfazer último atendimento");
            System.out.println("4. Listar processos pendentes");
            System.out.println("5. Listar histórico de atendimentos");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Opção inválida. Digite um número.");
                scanner.next();
                continue;
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do solicitante: ");
                    String solicitante = scanner.nextLine();

                    System.out.print("Tipo de serviço: ");
                    String tipoServico = scanner.nextLine();

                    int prioridade = 0;
                    while (prioridade < 1 || prioridade > 3) {
                        System.out.print("Prioridade (1=Baixa, 2=Normal, 3=Urgente): ");
                        if (scanner.hasNextInt()) {
                            prioridade = scanner.nextInt();
                            scanner.nextLine();
                        } else {
                            scanner.next();
                        }
                        if (prioridade < 1 || prioridade > 3) {
                            System.out.println("Prioridade inválida. Use 1, 2 ou 3.");
                        }
                    }

                    Processo p = new Processo(solicitante, tipoServico, prioridade);
                    central.abrirProcesso(p);
                    break;

                case 2:
                    try {
                        central.atenderProximo();
                    } catch (PilhaVaziaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        central.desfazerUltimoAtendimento();
                    } catch (PilhaVaziaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    central.listarPendentes();
                    break;

                case 5:
                    central.listarHistorico();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}