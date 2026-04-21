package src;

public class PilhaProcesso {

    private VetorDinamico dados;

    public PilhaProcesso() {
        this.dados = new VetorDinamico();
    }

    public void push(Processo p) {
        dados.adicionar(p);
    }

    public Processo pop() {
        if (estaVazio()) {
            throw new PilhaVaziaException("Não é possível: pilha vazia!");
        }
        return dados.remover(dados.getTamanho() - 1);
    }

    public boolean estaVazio() {
        return dados.estaVazio();
    }

}
