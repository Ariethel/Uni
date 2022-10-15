package org.example;

import java.io.Serializable;

public class Utente implements Serializable {
    private static final long serialVersionUID = 1L;
    public Utente(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    private String nome;
}
