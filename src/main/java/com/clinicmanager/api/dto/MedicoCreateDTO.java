package com.clinicmanager.api.dto;

import com.clinicmanager.api.dto.enums.Especialidade;

public record MedicoCreateDTO (
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
)
{ }
