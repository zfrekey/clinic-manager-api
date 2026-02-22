package com.clinicmanager.api.dto;

import com.clinicmanager.api.entity.enums.Especialidade;

public record MedicoResponseDTO(
            Long id,
            String name,
            String email,
            String crm,
            Especialidade especialidade,
            DadosEndereco endereco
) { }
