package com.clinicmanager.api.repositories;

import com.clinicmanager.api.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
}
