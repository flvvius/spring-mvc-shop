package com.example.magazin.loader;

import com.example.magazin.entity.Client;
import com.example.magazin.entity.Comanda;
import com.example.magazin.entity.enums.Stare;
import com.example.magazin.repository.ClientRepository;
import com.example.magazin.repository.ComandaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ComandaRepository comandaRepository;

    @Override
    public void run(String... args) {
        if (clientRepository.count() > 0) {
            return;
        }

        System.out.println("--- INCARCARE DATE DIN FISIER ---");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream("/data.txt"))
        ))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String nume = parts[0];
                String email = parts[1];
                String stareString = parts[2];

                Client client = Client.builder()
                        .nume(nume)
                        .email(email)
                        .build();

                Client clientSalvat = clientRepository.save(client);

                Comanda comanda = Comanda.builder()
                        .client(clientSalvat)
                        .stare(Stare.valueOf(stareString))
                        .dataPlasarii(LocalDate.now())
                        .build();

                comandaRepository.save(comanda);

                System.out.println("Salvat comanda pentru: " + nume);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
