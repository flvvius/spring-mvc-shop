package com.example.magazin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produse")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produs_id")
    private Long id;

    @NotNull
    private String nume;

    @NotNull
    private float pret;
}
