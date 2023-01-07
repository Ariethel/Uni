package canzoneSanremo;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    Integer id;
    String cantante;
    String primeParole;

    public MessageWrapper(Integer id, String cantante, String primeParole) {
        this.id = id;
        this.cantante = cantante;
        this.primeParole = primeParole;
    }

    public Integer getID(){
        return id;
    }
    
    public String getCantante() {
        return cantante;
    }

    public String getPrimeParole() {
        return primeParole;
    }

}
