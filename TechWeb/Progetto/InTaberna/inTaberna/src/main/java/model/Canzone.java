package model;

public class Canzone {

    public Canzone(String titolo, String a_titolo){
        this.titolo = titolo;
        this.a_titolo = a_titolo;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getA_titolo() {
        return a_titolo;
    }

    public void setA_titolo(String a_titolo) {
        this.a_titolo = a_titolo;
    }

    private String titolo,a_titolo;
}
