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

    public Processo peek() {
        if (estaVazio()) {
            throw new PilhaVaziaException("Não é possível: pilha vazia!");
        }
        return dados.obter(dados.getTamanho() - 1);
    }

    public int tamanho() {
        return dados.getTamanho();
    }

    public boolean estaVazio() {
        return dados.estaVazio();
    }

    public void imprimit() {
        if (estaVazio()) {
            System.out.println("Pilha vazia!!!");
            return;
        }
        System.out.println("===== TOPO =====");
        for (int i = dados.getTamanho() - 1; i >= 0; i--) {
            System.out.println(dados.obter(i));
        }
        System.out.println("==== BASE =====");
    }

    public void limpar() {
        while (!estaVazio()) {
            pop();
        }
    }

}
