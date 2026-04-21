package src;

public class TesteIntegracao {

    public static void main(String[] args) {
        CentralAtendimento central = new CentralAtendimento();

        System.out.println("=== TESTE DE INTEGRAÇÃO - PILHA DE PRIORIDADE ===\n");

        System.out.println("--- 1. Abrindo processos ---");
        Processo p1 = new Processo("Maria Auxiliadora", "Financeiro", 1); // baixa
        Processo p2 = new Processo("Pedro Henrique", "Saude", 2); // normal
        Processo p3 = new Processo("Vyctoria Karina", "Emergência", 3); // urgente
        Processo p4 = new Processo("Adson Show", "Administrativo", 1); // baixa
        Processo p5 = new Processo("Mariana Borga", "Saude", 3); // urgente (aberto por último)

        central.abrirProcesso(p1);
        central.abrirProcesso(p2);
        central.abrirProcesso(p3);
        central.abrirProcesso(p4);
        central.abrirProcesso(p5);

        System.out.println("\n--- 2. Listando processos pendentes (agrupados por prioridade) ---");
        central.listarPendentes();

        System.out.println("\n--- 3. Atendendo processos (urgentes primeiro) ---");
        System.out.println(
                "Esperando: Mariana (urgente), Vyctoria (urgente), Pedro (normal), Adson (baixa), Maria (baixa)");

        central.atenderProximo(); // deve ser Mariana (urgente, topo da pilha urgente)
        central.atenderProximo(); // deve ser Vyctoria (urgente)
        central.atenderProximo(); // deve ser Pedro (normal)
        central.atenderProximo(); // deve ser Adson (baixa, topo da pilha baixa)
        central.atenderProximo(); // deve ser Maria Auxiliadora (baixa)

        System.out.println("\n--- 4. Histórico de atendimentos ---");
        central.listarHistorico();

        System.out.println("\n--- 5. Pendentes após atender todos ---");
        central.listarPendentes();

        System.out.println("\n--- 6. Desfazendo último atendimento ---");
        central.desfazerUltimoAtendimento();
        central.listarPendentes();
        central.listarHistorico();

        System.out.println("\n--- 7. Cenários de erro ---");

        central.atenderProximo();

        System.out.println("\nTentando atender com pilha vazia:");
        try {
            central.atenderProximo();
        } catch (PilhaVaziaException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        central.abrirProcesso(new Processo("Teste", "Teste", 1));
        central.atenderProximo();
        central.abrirProcesso(new Processo("Teste2", "Teste2", 1));

        System.out.println("\nTentando desfazer sem histórico:");
        try {
            central.desfazerUltimoAtendimento();
        } catch (PilhaVaziaException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        System.out.println("\n=== TESTE FINALIZADO COM SUCESSO ===");
    }
}