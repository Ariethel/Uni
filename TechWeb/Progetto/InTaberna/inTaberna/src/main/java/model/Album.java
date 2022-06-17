package model;

public class Album {

    public Album(String titolo, int prezzo, boolean homepage){
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.homepage = homepage;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isHomepage() {
        return homepage;
    }

    public void setHomepage(boolean homepage) {
        this.homepage = homepage;
    }

    private String titolo;
    private int prezzo;
    private boolean homepage;
    //Vedere come inserire immagine
}
