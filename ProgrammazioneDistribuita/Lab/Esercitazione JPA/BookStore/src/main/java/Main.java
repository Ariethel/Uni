import entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookstore");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Book book = new Book();
        book.setIsbn("1234567890");
        book.setTitolo("Java Persistence API");
        book.setPrezzo(20.0);
        book.setDescrizione("Java Persistence API");
        book.setCategoria("Java");
        em.persist(book);
        tx.commit();
        em.close();
        emf.close();
    }
}
