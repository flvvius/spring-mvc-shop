package com.example.magazin.entity;

import com.example.magazin.entity.enums.Stare;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "comenzi")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Stare stare;

    private LocalDate dataPlasarii;

}
