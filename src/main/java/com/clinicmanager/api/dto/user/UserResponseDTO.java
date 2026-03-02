package com.clinicmanager.api.dto.user;


import com.clinicmanager.api.entity.UserEntity;

public record UserResponseDTO(
        String name,
        String email,
        String phone
) {
    public static UserResponseDTO toResponseDTO(UserEntity user) {
        return new UserResponseDTO(
                user.getName(),
                user.getEmail(),
                user.getPhone()
        );
    }
}
