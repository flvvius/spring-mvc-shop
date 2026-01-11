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

    public void modificaStare(Long id, Stare stareNoua) {

        if (stareNoua == Stare.LIVRATA) {
            throw new RuntimeException("Comanda este deja livrata! Starea nu se poate actualiza!");
        }

        Comanda comanda = comandaRepository.findById(id).orElseThrow(() -> new RuntimeException("Comanda nu exista!"));

        comanda.setStare(stareNoua);

        comandaRepository.save(comanda);

        trimiteNotificare(comanda);

    }

    public void anuleazaComanda(Long id) {
        Comanda comanda = comandaRepository.findById(id).orElseThrow(() -> new RuntimeException("Comanda nu exista!"));

        if (comanda.getStare() == Stare.PLASATA) {
            comanda.setStare(Stare.ANULATA);
            comandaRepository.save(comanda);
            trimiteNotificare(comanda);
        } else {
            System.out.println("Nu se poate anula comanda " + id + " deoarece aceasta este deja " + comanda.getStare());
        }
    }

    private void trimiteNotificare(Comanda c) {
        System.out.println(">>> NOTIFICARE EMAIL catre " + c.getClient().getEmail() +
                ": Comanda dvs. #" + c.getId() + " are acum starea: " + c.getStare());
    }

}
