package com.server;

public class Biglietto {
    private String nome;
    private String posto;
    public static int code;
    public Biglietto(String nome, String posto) {
        this.nome = nome;
        this.posto = Biglietto.code+ posto;
        code++;
    }
    
    public Biglietto() {
    }

    @Override
    public String toString() {
        return "Biglietto: " + nome + "-" + posto ;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPosto() {
        return posto;
    }
    public void setPosto(String posto) {
        this.posto = posto;
    }
    

    

}
