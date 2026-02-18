package com.clinicmanager.api.controllers;

import com.clinicmanager.api.dto.MedicoCreateDTO;
import com.clinicmanager.api.services.MedicoService; // Importe o Service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService service;

    @PostMapping
    public void cadastrar(@RequestBody MedicoCreateDTO data){
        service.create(data);
    }
}
