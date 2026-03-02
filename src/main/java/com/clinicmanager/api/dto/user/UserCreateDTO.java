package com.clinicmanager.api.dto.user;

public record UserCreateDTO(
        String name,
        String email,
        String cpf,
        String phone
) {
}
