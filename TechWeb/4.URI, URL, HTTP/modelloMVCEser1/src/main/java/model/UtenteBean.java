package model;

public class UtenteBean {
    // proprietà del bean corrispondente al campo cognome nel form
    private final String cognomeUtenteBean;

    // AGGIUNGERE LE ULTERIORI PROPRIETA' CORRISPONDENTI AI CAMPI DI INPUT DEL FORM

    public UtenteBean(String cognomeUtente) {  // MODIFICARE IL COSTRUTTORE PER POTER AGGIORNARE ANCHE LE NUOVE PROPRIETA'
        this.cognomeUtenteBean = cognomeUtente;
    }

    // il nome del getter  per la proprietà cognomeUtenteBean deve avere "get" seguito dal nome della proprietà messo in maiuscolo.
    public String getCognomeUtenteBean() {
        return cognomeUtenteBean;
    }

    // AGGIUNGERE I GETTERS PER LE NUOVE PROPRIETA' (CON I GIUSTI NOMI)

}
