package com.example.magazin.event;

import com.example.magazin.entity.Comanda;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StareSchimbataEvent {
    private final Comanda comanda;
}
