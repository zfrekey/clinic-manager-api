package com.clinicmanager.api.dto.medico;

import com.clinicmanager.api.entity.MedicoEntity;
import com.clinicmanager.api.entity.enums.Especialidade;

public record MedicoResponseDTO(
        String name,
        String email,
        String crm,
        String telefone,
        Especialidade especialidade
) {
    public static MedicoResponseDTO toResponseDTO(MedicoEntity medico) {
        return new MedicoResponseDTO(
                medico.getName(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade()

        );
    }
}
