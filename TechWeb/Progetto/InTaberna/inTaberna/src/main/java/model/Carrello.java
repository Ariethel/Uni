package model;

import java.util.ArrayList;

public class Carrello {

    public Carrello(String username, String password, String a_name){
        this.username = username;
        this.password = password;
        this.a_name = a_name;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumOrdine() {
        return numOrdine;
    }

    public void setNumOrdine(int numOrdine) {
        this.numOrdine = numOrdine;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    private String a_name;
    private String username, password;
    private int numOrdine;
    private double totale;
}
