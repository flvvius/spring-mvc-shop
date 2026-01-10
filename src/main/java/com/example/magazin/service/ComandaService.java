package com.example.magazin.service;

import com.example.magazin.repository.ComandaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ComandaService {

    ComandaRepository comandaRepository;

}
