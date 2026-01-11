package com.example.magazin.mapper;

import com.example.magazin.dto.ComandaDto;
import com.example.magazin.entity.Comanda;
import org.springframework.stereotype.Component;

@Component
public class ComandaMapper {

    public ComandaDto toDto(Comanda comanda) {
        return new ComandaDto(
                comanda.getId(),
                comanda.getClient().getNume(),
                comanda.getClient().getEmail(),
                comanda.getStare().toString(),
                comanda.getDataPlasarii()
        );
    }
}
