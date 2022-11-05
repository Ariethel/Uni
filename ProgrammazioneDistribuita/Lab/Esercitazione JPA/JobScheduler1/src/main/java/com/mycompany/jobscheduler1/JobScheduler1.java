/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.jobscheduler1;

import entity.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author amnesia
 */
public class JobScheduler1 {

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
        
        Job result = new Job("Risultati",9999,p1);
        List<Job> results = result.findAll();
        for(Job j: results){
            j.toString();
        }
        
    }
}