/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.jobscheduler;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author amnesia
 */
public class JobScheduler {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JobPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Creo due dipendenti
        tx.begin();
        Person p1 = new Person("Antonio", "Renzullo");
        Person p2 = new Person("Peppe","Carogna");
        em.persist(p1);
        em.persist(p2);
        tx.commit();
        
        //Creo 2 job, uno per dipendente
        tx.begin();
        Job j1 = new Job("Scrivere tesi", 2000, p1);
        Job j2 = new Job("Riparare macchina", 4000, p2);
        em.persist(j1);
        em.persist(j2);
        tx.commit();
        
        //Creo un 3 job solo per testing
        tx.begin();
        Job j3 = new Job("Derubare banca", 99999, p1);
        em.persist(j3);
        tx.commit();
        
        
        //Creo una query nativa e itero tra i risultati per stampare le informazioni che mi interessano
        //Importante indicare "Job.class" altrimenti non si riesce ad iterare tra gli elementi
        Query query = em.createNativeQuery("Select * From JOB ORDER BY EMPLOYEED_FIRSTNAME ",Job.class);
        List<Job> results = query.getResultList();
        System.out.println("\n\n\n##############################################################################");
        for (Job j: results){
            System.out.println(j.getEmployeed().getFirstName() + " " + j.getEmployeed().getLastName()+ " --> " + j.getTitle() );

        }
        System.out.println("##############################################################################\n\n\n");
        
        em.close();
        emf.close();
       
        
    }
}
