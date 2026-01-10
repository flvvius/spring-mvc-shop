package com.example.magazin.repository;

import com.example.magazin.entity.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Comanda, Long> {
}
