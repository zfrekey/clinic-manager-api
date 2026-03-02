package com.clinicmanager.api.services;

import com.clinicmanager.api.dto.user.UserCreateDTO;
import com.clinicmanager.api.dto.user.UserEditDTO;
import com.clinicmanager.api.dto.user.UserResponseDTO;
import com.clinicmanager.api.entity.UserEntity;
import com.clinicmanager.api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDTO create(UserCreateDTO data) {
        UserEntity user = new UserEntity();
        user.setName(data.name());
        user.setEmail(data.email());
        user.setPhone(data.phone());
        user.setCpf(data.cpf());

        try {
            UserEntity saved = userRepository.save(user);
            return UserResponseDTO.toResponseDTO(saved);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("E-mail ou CPF já cadastrado no sistema.");
        }
    }

    public List<UserResponseDTO> listAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDTO::toResponseDTO)
                .toList();
    }

    @Transactional
    public UserResponseDTO edit(Long id, UserEditDTO dto) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (dto.name() != null) user.setName(dto.name());
        if (dto.email() != null) user.setEmail(dto.email());
        if (dto.phone() != null) user.setPhone(dto.phone());

        UserEntity updated = userRepository.save(user);
        return UserResponseDTO.toResponseDTO(updated);
    }

    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        userRepository.deleteById(id);
    }
}