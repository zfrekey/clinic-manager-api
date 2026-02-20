package com.clinicmanager.api.repositories;

import com.clinicmanager.api.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
