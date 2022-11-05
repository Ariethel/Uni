/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author amnesia
 */
@Entity
@NamedQueries({
@NamedQuery(name="Job.findAll",
        query="SELECT * FROM Job"),
})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String title;
    private float salary;
    @ManyToOne //In questo modo la stringa employeed sara' chiave esterna di Job
    private Person employeed;

    public Job(String title, float salary, Person employeed) {
        this.title = title;
        this.salary = salary;
        this.employeed = employeed;
    }

    public Job() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public List<Job> findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JobPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Job> trovaTutto = em.createNamedQuery("Job.findAll", Job.class);
        List<Job> results = trovaTutto.getResultList();
        return results;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getEmployeed() {
        return employeed;
    }

    public void setEmployeed(Person employeed) {
        this.employeed = employeed;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString(){
        return "Job: " + this.title + "\t Employeed: " + this.employeed.getFirstName();
    }

    
}