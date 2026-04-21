package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Processo {
    private static int contador = 0;
    private final int protocolo;
    private String solicitante;
    private String tipoServico;
    private int prioridade; // 1 - baixa; 2 - normal; 3 - urgente
    private String dataHora;

    public Processo(String solicitante, String tipoServico, int prioridade) {
        contador++;
        this.protocolo = contador;
        this.solicitante = solicitante;
        this.tipoServico = tipoServico;
        this.prioridade = prioridade;
        this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public int getProtocolo() {
        return protocolo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getDataHora() {
        return dataHora;
    }

}
