package src;

public class VetorDinamico {

    private Processo[] dados;
    private int tamanho;
    private final int capacidadeInicial;

    public VetorDinamico() {
        this(4);
    }

    public VetorDinamico(int capacidadeInicial) {
        this.capacidadeInicial = capacidadeInicial;
        this.dados = new Processo[capacidadeInicial];
        this.tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getCapacidade() {
        return dados.length;
    }

    public void adicionar(Processo p) {
        if (tamanho == dados.length) {
            redimensionar(dados.length * 2);
        }
        dados[tamanho] = p;
        tamanho++;
    }

    private void redimensionar(int novaCapacidade) {
        Processo[] novo = new Processo[novaCapacidade];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = dados[i];
        }
        dados = novo;
    }

}
