package model;

import java.io.File;
import java.io.InputStream;

public class Album {

    public Album(String titolo, double prezzo, InputStream file , boolean homepage){
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.img = file;
        this.homepage = homepage;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isHomepage() {
        return homepage;
    }

    public void setHomepage(boolean homepage) {
        this.homepage = homepage;
    }

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }

    private String titolo;
    private double prezzo;
    private boolean homepage;
    private InputStream img;
}
