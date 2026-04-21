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

    public Processo remover(int indice) {
        // dps criar método que verifica o indice e chamar aqui
        Processo removido = dados[indice];
        for (int i = indice; i < tamanho; i++) {
            dados[i] = dados[i + 1];
        }
        dados[tamanho - 1] = null;
        tamanho--;

        if (dados.length > capacidadeInicial && tamanho < dados.length / 4) {
            int novaCapacidade = Math.max(dados.length / 2, capacidadeInicial);
            redimensionar(novaCapacidade);
        }

        return removido;
    }

    private void redimensionar(int novaCapacidade) {
        Processo[] novo = new Processo[novaCapacidade];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = dados[i];
        }
        dados = novo;
    }

}
