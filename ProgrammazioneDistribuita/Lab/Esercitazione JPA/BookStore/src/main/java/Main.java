import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsempioJPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1 - Inserisci\n2 - Rimuovi\n3 - Cerca\n0 - Esci\n\nInsersci scelta: ");
            switch (sc.nextInt()){
                case 1:
                    tx.begin();
                    Book b = new Book();
                    System.out.println("Inserisci isbn: ");
                    b.setIsbn(sc.next());
                    System.out.println("Inserisci titolo: ");
                    b.setTitolo(sc.next());
                    System.out.println("Inserisci prezzo: ");
                    b.setPrezzo(sc.nextDouble());
                    System.out.println("Inserisci descrizione: ");
                    b.setDescrizione(sc.next());
                    System.out.println("Inserisci categoria: ");
                    b.setCategoria(sc.next());
                    em.persist(b);
                    tx.commit();
                    break;
                case 2:
                    tx.begin();
                    System.out.println("Inserisci isbn: ");
                    Book b1 = em.find(Book.class, sc.next());
                    em.remove(b1);
                    tx.commit();
                    break;
                case 3:
                    System.out.println("Inserisci isbn: ");
                    Book b2 = em.find(Book.class, sc.next());
                    b2.toString();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
