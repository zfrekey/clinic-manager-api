package com.socialmedia.api.dto;

public record MedicoCreateDTO (
        String nome,
        String email,
        String crm,
        Especialidade especialidae
)
{ }
