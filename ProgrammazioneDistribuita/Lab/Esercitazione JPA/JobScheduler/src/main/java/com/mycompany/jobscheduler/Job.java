/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.jobscheduler;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author amnesia
 */
@Entity
@Table(name= "JOB")
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
        return "Job: " + this.title + "\t Employeed: " + this.employeed.getFirstName() +" "+this.employeed.getLastName();
    }

    
}
