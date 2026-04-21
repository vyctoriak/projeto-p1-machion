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
        verificarIndice(indice);
        Processo removido = dados[indice];
        for (int i = indice; i < tamanho; i++) {
            dados[i] = dados[i + 1];
        }
        dados[tamanho - 1] = null;
        tamanho--;

        // reduz capacidade se a ocupação for menor que 25%
        // e capacidad atual for maior que inicial
        if (dados.length > capacidadeInicial && tamanho < dados.length / 4) {
            int novaCapacidade = Math.max(dados.length / 2, capacidadeInicial);
            redimensionar(novaCapacidade);
        }

        return removido;
    }

    public Processo obter(int indice) {
        verificarIndice(indice);
        return dados[indice];
    }

    public void listar() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println((i + 1) + ". " + dados[i]);
        }
    }

    public int buscaPorProtocolo(int protocolo) {
        for (int i = 0; i < tamanho; i++) {
            if (dados[i].getProtocolo() == protocolo) {
                return i;
            }
        }
        return -1;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    private void redimensionar(int novaCapacidade) {
        Processo[] novo = new Processo[novaCapacidade];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = dados[i];
        }
        dados = novo;
    }

    private void verificarIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice + " (tamanho atual: " + tamanho + ")");
        }
    }

}
