package dpcm;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class DecretoEJB implements DecretoEJBRemote {
    @Inject 
    private EntityManager em;
        
    @Override
    public void aggiungiDecreto(Decreto d) {
        em.persist(d);
    }

    @Override
    public void aggiornaDecreto(Decreto d) {
        em.merge(d);
    }

    @Override
    public void eliminaDecreto(Decreto d) {
        em.remove(em.merge(d));
    }

    @Override
    public List<Decreto> trovaTuttiDecreti() {
        TypedQuery<Decreto> query = em.createNamedQuery(Decreto.TROVA_TUTTI, Decreto.class);
        return query.getResultList();
    }

    @Override
    public List<Decreto> trovaPerEmergenza(String emergenza) {
        TypedQuery<Decreto> query = em.createNamedQuery(Decreto.TROVA_PER_EMERGENZA, Decreto.class);
        query.setParameter("emergenza", emergenza);
        return query.getResultList();
    }

    @Override
    public List<Decreto> trovaPerCategoria(String categoria) {
        TypedQuery<Decreto> query = em.createNamedQuery(Decreto.TROVA_PER_CATEGORIA, Decreto.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    @Override
    public List<Decreto> trovaPerNumeroPresentazioniStampa(Integer x) {
        TypedQuery<Decreto> query = em.createNamedQuery(Decreto.TROVA_PER_PRESENTAZIONI_STAMPA, Decreto.class);
        query.setParameter(1, x);
        return query.getResultList();
    }

    @Override
    public Decreto trovaPerId(Integer id) {
        TypedQuery<Decreto> query = em.createNamedQuery(Decreto.TROVA_PER_ID, Decreto.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    
}
