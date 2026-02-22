package com.clinicmanager.api.dto;

import com.clinicmanager.api.entity.Medico;
import com.clinicmanager.api.entity.enums.Especialidade;

public record MedicoResponseDTO(
        String name,
        String email,
        String crm,
        Especialidade especialidade
) {
    public static MedicoResponseDTO toResponseDTO(Medico medico) {
        return new MedicoResponseDTO(
                medico.getName(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade()
        );
    }
}
