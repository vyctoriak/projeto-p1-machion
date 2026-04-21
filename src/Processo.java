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

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    private String rotuloPrioridade() {
        switch (prioridade) {
            case 1:
                return "Baixa";
            case 2:
                return "Normal";
            case 3:
                return "Urgente";
            default:
                return "Prioridade desconhecida";
        }
    }

    @Override
    public String toString() {
        return String.format("[#%03d] %s | %s | %s | %s", protocolo, solicitante, tipoServico, rotuloPrioridade(),
                dataHora);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Processo outro = (Processo) obj;
        return this.protocolo == outro.protocolo;
    }

}
