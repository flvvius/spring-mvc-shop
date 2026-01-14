package com.example.magazin.pattern;

import com.example.magazin.entity.Comanda;
import com.example.magazin.entity.enums.Stare;

public class StarePlasata implements StateComanda {
    @Override
    public void avanseaza(Comanda comanda) {
        comanda.setStare(Stare.PROCESATA);
        System.out.println("Comanda a trecut în starea PROCESATA.");
    }

    @Override
    public void anuleaza(Comanda comanda) {
        comanda.setStare(Stare.ANULATA);
        System.out.println("Comanda a fost ANULATA.");
    }
}
