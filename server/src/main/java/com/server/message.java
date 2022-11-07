package com.server;

import java.util.ArrayList;

public class message {
    ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();

    
    public message() {
    }

    public ArrayList<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(ArrayList<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }
    public void add(Biglietto b)
    {
        biglietti.add(b);
    }
    public void remove (Biglietto b)
    {
        biglietti.remove(b);
    }
}
