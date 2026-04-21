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

    public Processo pop() {
        if (!pilhaUrgente.estaVazio()) {
            return pilhaUrgente.pop();
        } else if (!pilhaNormal.estaVazio()) {
            return pilhaNormal.pop();
        } else if (!pilhaBaixa.estaVazio()) {
            return pilhaBaixa.pop();
        } else {
            throw new PilhaVaziaException("Não é possível remover: todas as pilhas estão vazias.");
        }
    }

    public boolean estaVazia() {
        return pilhaBaixa.estaVazio() && pilhaNormal.estaVazio() && pilhaUrgente.estaVazio();
    }

}
