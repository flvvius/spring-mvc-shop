package com.example.magazin.service;

import com.example.magazin.dto.ComandaDto;
import com.example.magazin.entity.Comanda;
import com.example.magazin.entity.enums.Stare;
import com.example.magazin.mapper.ComandaMapper;
import com.example.magazin.repository.ComandaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComandaService {

    private final ComandaRepository comandaRepository;
    private final ComandaMapper comandaMapper;

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
        trimiteNotificare(comanda);

    }

    public void anuleazaComanda(Long id) {
        Comanda comanda = comandaRepository.findById(id).orElseThrow(() -> new RuntimeException("Comanda nu exista!"));

        try {
            comanda.anuleazaComanda();
            comandaRepository.save(comanda);
            trimiteNotificare(comanda);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    private void trimiteNotificare(Comanda c) {
        System.out.println(">>> NOTIFICARE EMAIL catre " + c.getClient().getEmail() +
                ": Comanda dvs. #" + c.getId() + " are acum starea: " + c.getStare());
    }

}
