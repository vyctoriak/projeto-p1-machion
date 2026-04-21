package src;

public class CentralAtendimento {

    private PilhaProcesso pilhaPrincipal;
    private PilhaProcesso pilhaAuxiliar;

    public CentralAtendimento() {
        this.pilhaPrincipal = new PilhaProcesso();
        this.pilhaAuxiliar = new PilhaProcesso();
    }

    public void abrirProcesso(Processo p) {
        pilhaPrincipal.push(p);
        pilhaAuxiliar.limpar();
        System.out.println("Processo aberto: " + p);
    }

    public void atenderProximo() {
        Processo atendido = pilhaPrincipal.pop();
        pilhaAuxiliar.push(atendido);
        System.out.println("Processo atendido: " + atendido);
    }

    public void desfazerUltimoAtendimento() {
        Processo desfeito = pilhaAuxiliar.pop();
        pilhaPrincipal.push(desfeito);
        System.out.println("Atendimento desfeito. Processo retornou a fila: " + desfeito);
    }

    public void listarPendentes() {
        System.out.println("=== PROCESSOS PENDENTES ===");
        pilhaPrincipal.imprimir();
    }

    public void listarHistorico() {
        System.out.println("=== HISTÓRICO DE ATENDIMENTOS ===");
        pilhaAuxiliar.imprimir();
    }
}