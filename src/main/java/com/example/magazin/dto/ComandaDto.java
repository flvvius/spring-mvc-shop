package com.example.magazin.dto;


import java.time.LocalDate;

public record ComandaDto(Long id, String numeClient, String emailClient, String stare, LocalDate dataPlasarii) {
}
