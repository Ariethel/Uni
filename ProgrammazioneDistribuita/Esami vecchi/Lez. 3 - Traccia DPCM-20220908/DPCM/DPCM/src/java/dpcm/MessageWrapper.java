package dpcm;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    private Integer id;
    private Integer aggiornamento_numero_presentazioni;

    public MessageWrapper(Integer id, Integer aggiornamento_numero_presentazioni) {
        this.id = id;
        this.aggiornamento_numero_presentazioni = aggiornamento_numero_presentazioni;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAggiornamento_numero_presentazioni() {
        return aggiornamento_numero_presentazioni;
    }
    
    
}
