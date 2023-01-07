package dpcm;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface DecretoEJBRemote {
    void aggiungiDecreto(Decreto d);
    void aggiornaDecreto(Decreto d);
    void eliminaDecreto(Decreto d);
    
    List<Decreto> trovaTuttiDecreti();
    List<Decreto> trovaPerEmergenza(String emergenza);
    List<Decreto> trovaPerCategoria(String categoria);
    List<Decreto> trovaPerNumeroPresentazioniStampa(Integer x);
    Decreto trovaPerId(Integer id);
    
}
