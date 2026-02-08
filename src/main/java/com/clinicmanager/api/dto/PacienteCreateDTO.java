package com.clinicmanager.api.dto;

public record PacienteCreateDTO (
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco
){
}
