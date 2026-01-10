package com.example.magazin.repository;

import com.example.magazin.entity.Comanda;
import com.example.magazin.entity.enums.Stare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    List<Comanda> findByStare(Stare stare);
}
