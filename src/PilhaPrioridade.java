package src;

public class PilhaPrioridade {
    private PilhaProcesso pilhaBaixa; // prioridade 1
    private PilhaProcesso pilhaNormal; // prioridade 2
    private PilhaProcesso pilhaUrgente; // prioridade 3

    public PilhaPrioridade() {
        this.pilhaBaixa = new PilhaProcesso();
        this.pilhaNormal = new PilhaProcesso();
        this.pilhaUrgente = new PilhaProcesso();
    }

    public void push(Processo p) {
        switch (p.getPrioridade()) {
            case 1:
                pilhaBaixa.push(p);
                break;
            case 2:
                pilhaNormal.push(p);
                break;
            case 3:
                pilhaUrgente.push(p);
                break;
            default:
                System.out.println("Prioridade inválida!");
        }
    }
}
