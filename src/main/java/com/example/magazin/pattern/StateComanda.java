package com.example.magazin.pattern;

import com.example.magazin.entity.Comanda;

public interface StateComanda {

    default void avanseaza(Comanda comanda) {
        throw new IllegalStateException("Nu se poate avansa din starea curentă: " + comanda.getStare());
    }

    default void anuleaza(Comanda comanda) {
        throw new IllegalStateException("Nu se poate avansa din starea curentă: " + comanda.getStare());
    }

}
