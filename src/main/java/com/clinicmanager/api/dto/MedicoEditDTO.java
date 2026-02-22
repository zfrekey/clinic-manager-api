package com.clinicmanager.api.dto;

import com.clinicmanager.api.entity.enums.Especialidade;

public record MedicoEditDTO(
        String name,
        String email,
        Especialidade especialidade,
        DadosEndereco endereco
) { }
