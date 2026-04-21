package src;

public class TesteVetorDinamico {

    public static void main(String[] args) {
        VetorDinamico vetor = new VetorDinamico();
        System.out.println("Capacidade inicial: " + vetor.getCapacidade());
        System.out.println();

        System.out.println("===== Inserções =====");
        String[] nomes = {
                "Vyctoria Karina", "Adson Lima", "Pietro Zonta", "Mariana Borgato",
                "Pedro Henrique", "Samuel Dantas", "Durga Vieira", "Parvati Maria",
                "Igor Santos", "Julia Camboja", "Luan Rocha", "Laura Silva",
        };

        for (int i = 0; i < nomes.length; i++) {
            int prioridade = (i % 3) + 1;
            Processo p = new Processo(nomes[i], "Serviço " + (i + 1), prioridade);
            vetor.adicionar(p);
            System.out.println("Adicionado: " + p + " | Tamanho: " + vetor.getTamanho() + " | Capacidade: "
                    + vetor.getCapacidade());
        }

        vetor.listar();

        System.out.println("===== Busca por protocolo =====");
        int protocoloBuscado = 5;
        int indiceBusca = vetor.buscaPorProtocolo(protocoloBuscado);
        if (indiceBusca != -1) {
            System.out.println("Protocolo " + protocoloBuscado + " encontrado no indice " + indiceBusca + ": "
                    + vetor.obter(indiceBusca));
        } else {
            System.out.println("Protocolo " + protocoloBuscado + " não encontrado.");
        }

        int protocoloInexistente = 50;
        int indiceBusca2 = vetor.buscaPorProtocolo(protocoloInexistente);
        System.out.println("Protocolo " + protocoloInexistente
                + (indiceBusca2 == -1 ? " nao encontrado." : " encontrado no indice " + indiceBusca2));

        System.out.println("==== Remoções (do final para o inicio) ====");
        int totalRemocoes = vetor.getTamanho();
        for (int i = totalRemocoes - 1; i >= 0; i--) {
            Processo removido = vetor.remover(i);
            System.out.println("Removido: " + removido + " | Tamanho: " + vetor.getTamanho() + " | Capacidade: "
                    + vetor.getCapacidade());
        }

        System.out.println("Vetor vazio? " + vetor.estaVazio());
        System.out.println("Capacidade final: " + vetor.getCapacidade());
    }
}
