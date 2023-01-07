package canzoneSanremo;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@WebService
@Stateless
@LocalBean
public class CanzoneEJB implements CanzoneEJBRemote {

    @Inject 
    private EntityManager em;
    
    @Override
    public void aggiungiCanzone(Canzone c) {
        em.persist(c);
    }

    @Override
    public void aggiornaCanzone(Canzone c) {
        em.merge(c);
    }

    @Override
    public void eliminaCanzone(Canzone c) {
        em.remove(em.merge(c));
    }

    @Override
    @Counter
    public List<Canzone> trovaTutteCanzoni() {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.TROVA_TUTTI, Canzone.class);
        return query.getResultList();
    }

    @Override
    @Counter
    public List<Canzone> trovaPerCategoria(String categoria) {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.TROVA_PER_CATEGORIA, Canzone.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    @Override
    public Canzone trovaPerId(int id) {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.TROVA_PER_ID, Canzone.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    @CheckParameters
    public List<Canzone> trovaPerVoti(Integer voti) {
        TypedQuery<Canzone> query = em.createNamedQuery(Canzone.TROVA_PER_VOTI, Canzone.class);
        query.setParameter("voti", voti);
        return query.getResultList();
    }
    
}
