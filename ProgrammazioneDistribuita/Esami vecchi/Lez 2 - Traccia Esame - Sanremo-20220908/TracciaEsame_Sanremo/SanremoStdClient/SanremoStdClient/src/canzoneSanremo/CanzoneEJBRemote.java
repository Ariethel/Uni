package canzoneSanremo;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CanzoneEJBRemote {
    void aggiungiCanzone(Canzone c);
    void aggiornaCanzone(Canzone c);
    void eliminaCanzone(Canzone c);
    
    List<Canzone> trovaTutteCanzoni();
    List<Canzone> trovaPerCategoria(String categoria);
    List<Canzone> trovaPerVoti(Integer voti);
    Canzone trovaPerId(int id);
    
}
