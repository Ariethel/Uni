package dpcm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static dpcm.Decreto.TROVA_PER_ID;
import static dpcm.Decreto.TROVA_TUTTI;
import static dpcm.Decreto.TROVA_PER_EMERGENZA;
import static dpcm.Decreto.TROVA_PER_CATEGORIA;
import static dpcm.Decreto.TROVA_PER_PRESENTAZIONI_STAMPA;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT d FROM Decreto d"),
    @NamedQuery(name = TROVA_PER_ID, query = "SELECT d FROM Decreto d WHERE d.id = :id"),
    @NamedQuery(name = TROVA_PER_EMERGENZA, query = "SELECT d FROM Decreto d WHERE d.emergenza = :emergenza"),
    @NamedQuery(name = TROVA_PER_CATEGORIA, query = "SELECT d FROM Decreto d WHERE d.tipo_emergenza = :categoria"),
    @NamedQuery(name = TROVA_PER_PRESENTAZIONI_STAMPA, query = "SELECT d FROM Decreto d WHERE d.numero_presentazioni_stampa > ?1")
})
public class Decreto implements Serializable{
    public static final String TROVA_PER_ID = "Decreto.trovaPerId";
    public static final String TROVA_TUTTI = "Decreto.trovaTutti";
    public static final String TROVA_PER_EMERGENZA = "Decreto.trovaPerEmergenza";
    public static final String TROVA_PER_CATEGORIA = "Decreto.trovaPerCategoria";
    public static final String TROVA_PER_PRESENTAZIONI_STAMPA = "Decreto.trovaPerPresentazioniStampa";
    
    @Id 
    private Integer id;
    private String nome; 
    private String emergenza;
    private String tipo_emergenza;
    private String livello_lock_down;
    private int numero_presentazioni_stampa;

    public Decreto() {
    }

    public Decreto(Integer id, String nome, String emergenza, String tipo_emergenza, String livello_lock_down, int numero_presentazioni_stampa) {
        this.id = id;
        this.nome = nome;
        this.emergenza = emergenza;
        this.tipo_emergenza = tipo_emergenza;
        this.livello_lock_down = livello_lock_down;
        this.numero_presentazioni_stampa = numero_presentazioni_stampa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmergenza() {
        return emergenza;
    }

    public void setEmergenza(String emergenza) {
        this.emergenza = emergenza;
    }

    public String getTipo_emergenza() {
        return tipo_emergenza;
    }

    public void setTipo_emergenza(String tipo_emergenza) {
        this.tipo_emergenza = tipo_emergenza;
    }

    public String getLivello_lock_down() {
        return livello_lock_down;
    }

    public void setLivello_lock_down(String livello_lock_down) {
        this.livello_lock_down = livello_lock_down;
    }

    public int getNumero_presentazioni_stampa() {
        return numero_presentazioni_stampa;
    }

    public void setNumero_presentazioni_stampa(int numero_presentazioni_stampa) {
        this.numero_presentazioni_stampa = numero_presentazioni_stampa;
    }

    @Override
    public String toString() {
        return "Decreto{" + "id=" + id + ", nome=" + nome + ", emergenza=" + emergenza + ", tipo_emergenza=" + tipo_emergenza + ", livello_lock_down=" + livello_lock_down + ", numero_presentazioni_stampa=" + numero_presentazioni_stampa + '}';
    }
    
    
}
