package com.clinicmanager.api.controllers;

import com.clinicmanager.api.dto.MedicoCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody MedicoCreateDTO dados){
        return;
    }
}
