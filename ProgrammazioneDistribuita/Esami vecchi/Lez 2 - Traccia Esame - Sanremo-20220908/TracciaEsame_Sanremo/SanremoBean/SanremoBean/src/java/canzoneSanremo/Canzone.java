package canzoneSanremo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import static canzoneSanremo.Canzone.TROVA_TUTTI;
import static canzoneSanremo.Canzone.TROVA_PER_ID;
import static canzoneSanremo.Canzone.TROVA_PER_CATEGORIA;
import static canzoneSanremo.Canzone.TROVA_PER_VOTI;
import java.io.Serializable;


@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT c FROM Canzone c"),
    @NamedQuery(name = TROVA_PER_ID, query = "SELECT c FROM Canzone c WHERE c.id = ?1"),
    @NamedQuery(name = TROVA_PER_CATEGORIA, query = "SELECT c FROM Canzone c WHERE c.categoria = :categoria"),
    @NamedQuery(name = TROVA_PER_VOTI, query = "SELECT c FROM Canzone c WHERE c.votiRicevuti > :voti"),
})
@XmlRootElement
public class Canzone implements Serializable {
    public static final String TROVA_TUTTI = "Canzone.trovaTutti";
    public static final String TROVA_PER_ID = "Canzone.trovaPerId";
    public static final String TROVA_PER_CATEGORIA = "Canzone.trovaPerCategoria";
    public static final String TROVA_PER_VOTI = "Canzone.trovaPerVoti";
    
    @Id 
    private Integer id;
    private String nomeCantante;
    private String categoria;
    private String incipit;
    private Boolean cantato;
    private Integer votiRicevuti;

    public Canzone() {
    }

    public Canzone(Integer id, String nomeCantante, String categoria, String incipit, Boolean cantato, Integer votiRicevuti) {
        this.id = id;
        this.nomeCantante = nomeCantante;
        this.categoria = categoria;
        this.incipit = incipit;
        this.cantato = cantato;
        this.votiRicevuti = votiRicevuti;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCantante() {
        return nomeCantante;
    }

    public void setNomeCantante(String nomeCantante) {
        this.nomeCantante = nomeCantante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIncipit() {
        return incipit;
    }

    public void setIncipit(String incipit) {
        this.incipit = incipit;
    }

    public Boolean getCantato() {
        return cantato;
    }

    public void setCantato(Boolean cantato) {
        this.cantato = cantato;
    }

    public Integer getVotiRicevuti() {
        return votiRicevuti;
    }

    public void setVotiRicevuti(Integer votiRicevuti) {
        this.votiRicevuti = votiRicevuti;
    }

    @Override
    public String toString() {
        return "Canzone{id=" + id + ", nomeCantante=" + nomeCantante + ", categoria=" + categoria + ", incipit=" + incipit + ", cantato=" + cantato + ", votiRicevuti=" + votiRicevuti + '}';
    }
    
    
}
