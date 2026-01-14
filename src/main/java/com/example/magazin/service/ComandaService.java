package com.example.magazin.service;

import com.example.magazin.dto.ComandaDto;
import com.example.magazin.entity.Comanda;
import com.example.magazin.entity.enums.Stare;
import com.example.magazin.event.StareSchimbataEvent;
import com.example.magazin.mapper.ComandaMapper;
import com.example.magazin.repository.ComandaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComandaService {

    private final ComandaRepository comandaRepository;
    private final ComandaMapper comandaMapper;
    private final ApplicationEventPublisher eventPublisher;

    public List<ComandaDto> getToateComenzile(Stare filtruStare) {
        List<Comanda> comenzi;

        if (filtruStare != null) {
            comenzi = comandaRepository.findByStare(filtruStare);
        } else {
            comenzi = comandaRepository.findAll();
        }

        return comenzi.stream().map(comandaMapper::toDto).toList();
    }

    public void modificaStare(Long id) {

        Comanda comanda = comandaRepository.findById(id).orElseThrow(() -> new RuntimeException("Comanda nu exista!"));

        comanda.avanseazaStare();
        comandaRepository.save(comanda);
        eventPublisher.publishEvent(new StareSchimbataEvent(comanda));

    }

    public void anuleazaComanda(Long id) {
        Comanda comanda = comandaRepository.findById(id).orElseThrow(() -> new RuntimeException("Comanda nu exista!"));

        try {
            comanda.anuleazaComanda();
            comandaRepository.save(comanda);
            eventPublisher.publishEvent(new StareSchimbataEvent(comanda));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

}
