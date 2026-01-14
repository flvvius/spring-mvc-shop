package com.example.magazin.pattern;

import com.example.magazin.entity.enums.Stare;

public class StateFactory {
    public static StateComanda getStare(Stare stareEnum) {
        return switch (stareEnum) {
            case PLASATA -> new StarePlasata();
            case PROCESATA -> new StareProcesata();
            case EXPEDIATA -> new StareExpediata();
            case LIVRATA -> new StareLivrata();
            case ANULATA -> new StareAnulata();
            default -> throw new IllegalArgumentException("Stare necunoscută");
        };
    }
}
