package com.clinicmanager.api.repositories;

import com.clinicmanager.api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

