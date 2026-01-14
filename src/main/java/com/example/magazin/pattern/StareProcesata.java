package com.example.magazin.pattern;

import com.example.magazin.entity.Comanda;
import com.example.magazin.entity.enums.Stare;

public class StareProcesata implements StateComanda {
    @Override
    public void avanseaza(Comanda comanda) {
        comanda.setStare(Stare.EXPEDIATA);
    }
}
