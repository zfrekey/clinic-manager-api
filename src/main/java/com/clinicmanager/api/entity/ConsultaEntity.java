package com.clinicmanager.api.entity;

import com.clinicmanager.api.entity.enums.StatusConsulta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private UserEntity paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private MedicoEntity medico;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    private String motivo;

    private String observacoes;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status = StatusConsulta.AGENDADA;
}