package com.clinicmanager.api.entity;

import com.clinicmanager.api.dto.DadosEndereco;
import com.clinicmanager.api.entity.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;

@Table(name= "medicos")
@Entity(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
    private DadosEndereco Endereco;

}
