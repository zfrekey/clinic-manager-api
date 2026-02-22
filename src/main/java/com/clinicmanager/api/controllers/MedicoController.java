package com.clinicmanager.api.controllers;

import com.clinicmanager.api.dto.MedicoCreateDTO;
import com.clinicmanager.api.dto.MedicoEditDTO;
import com.clinicmanager.api.dto.MedicoResponseDTO;
import com.clinicmanager.api.services.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicoResponseDTO createMedico(@Valid @RequestBody MedicoCreateDTO data){
        return medicoService.create(data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        medicoService.delete(id);
    }

    @PatchMapping("/{id}")
    public MedicoResponseDTO edit(@PathVariable Long id, @RequestBody MedicoEditDTO medico){
        return medicoService.edit(id, medico);
    }

    @GetMapping()
    public UserReponseDTO listAll(){
        return medicoService.listAll();
    }
}
