package com.example.magazin.entity;

import com.example.magazin.entity.enums.Stare;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comenzi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "produs_id")
    private List<Produs> produse;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Stare stare;

    @Column(name = "data_plasare")
    private Date dataPlasare;

    @Column(name = "data_ultima_actualizare")
    private Date dataUltimaActualizare;

}
