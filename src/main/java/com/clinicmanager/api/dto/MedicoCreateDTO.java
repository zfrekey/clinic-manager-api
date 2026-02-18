package com.clinicmanager.api.dto;

import com.clinicmanager.api.entity.enums.Especialidade;

public record MedicoCreateDTO(
        String name,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco

)
{ }
