package com.clinicmanager.api.dto.medico;

import com.clinicmanager.api.entity.enums.Especialidade;

public record MedicoEditDTO(
        String name,
        String email,
        String telefone,
        Especialidade especialidade
) { }
