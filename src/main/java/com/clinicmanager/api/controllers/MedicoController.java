package com.clinicmanager.api.controllers;

import com.clinicmanager.api.dto.medico.MedicoCreateDTO;
import com.clinicmanager.api.dto.medico.MedicoEditDTO;

import com.clinicmanager.api.dto.medico.MedicoResponseDTO;
import com.clinicmanager.api.services.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public MedicoResponseDTO createMedico(@Valid @RequestBody MedicoCreateDTO data){
        return medicoService.create(data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        medicoService.delete(id);
    }

    @PatchMapping("/{id}")
    public MedicoResponseDTO edit(@PathVariable Long id, @Valid @RequestBody MedicoEditDTO medico){
        return medicoService.edit(id, medico);
    }

    @GetMapping()
    public List<MedicoResponseDTO> listAll(){
        return medicoService.listAll();
    }
}
