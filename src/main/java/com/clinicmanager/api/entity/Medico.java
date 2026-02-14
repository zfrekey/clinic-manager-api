package com.clinicmanager.api.entity;

import com.clinicmanager.api.dto.enums.Especialidade;
import com.clinicmanager.api.entity.Endereco;
import jakarta.persistence.*;

@Table(name= "medicos")
@Entity(name = "Medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco Endereco;
}
