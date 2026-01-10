package com.example.magazin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clienti")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @NotNull
    private String nume;

    @Email
    private String email;

    @NotNull
    private String telefon;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Comanda> comenzi;
}
