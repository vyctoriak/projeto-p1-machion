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

}
