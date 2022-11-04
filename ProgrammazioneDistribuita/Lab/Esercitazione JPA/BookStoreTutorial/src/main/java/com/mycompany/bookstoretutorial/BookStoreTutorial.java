/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bookstoretutorial;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author amnesia
 */
public class BookStoreTutorial {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1 - Inserisci\n2 - Rimuovi\n3 - Cerca\n0 - Esci\n\nInsersci scelta: ");
            switch (sc.nextInt()){
                case 1 -> {
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
                    em.persist(b);
                    tx.commit();
                }
                case 2 -> {
                    tx.begin();
                    System.out.println("Inserisci isbn: ");
                    Book b1 = em.find(Book.class, sc.next());
                    em.remove(b1);
                    tx.commit();
                }
                case 3 -> {
                    System.out.println("Inserisci isbn: ");
                    Book b2 = em.find(Book.class, sc.next());
                    if (b2 == null)
                        System.out.println("Oggetto non trovato");
                    else b2.toString();
                }
                case 0 -> System.exit(0);
            }
        }
    }
}
