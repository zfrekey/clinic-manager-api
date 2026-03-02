package com.clinicmanager.api.entity;

import com.clinicmanager.api.entity.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(unique = true)
    private String crm;

    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultaEntity> consultas = new ArrayList<>();
}