package com.clinicmanager.api.services;

import com.clinicmanager.api.dto.DadosEndereco;
import com.clinicmanager.api.dto.medico.MedicoCreateDTO;
import com.clinicmanager.api.dto.medico.MedicoEditDTO;
import com.clinicmanager.api.dto.medico.MedicoResponseDTO;
import com.clinicmanager.api.entity.EnderecoEntity;
import com.clinicmanager.api.entity.MedicoEntity;
import com.clinicmanager.api.repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.clinicmanager.api.dto.medico.MedicoResponseDTO.toResponseDTO;


@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoResponseDTO create(MedicoCreateDTO data) {
        MedicoEntity medico = new MedicoEntity();
        medico.setName(data.name());
        medico.setEmail(data.email());
        medico.setCrm(data.crm());
        medico.setEspecialidade(data.especialidade());

        try {
            MedicoEntity saved = medicoRepository.save(medico);
            return toResponseDTO(saved);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("CRM já cadastrado");
        }
    }

    public List<MedicoResponseDTO> listAll(){
        return medicoRepository.findAll()
                .stream()
                .map(MedicoResponseDTO::toResponseDTO)
                .toList();
    }

    public MedicoResponseDTO edit(Long id, MedicoEditDTO dto){

        MedicoEntity medico = medicoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (dto.name() != null) {
            medico.setName(dto.name());
        }
        if (dto.email() != null) {
            medico.setEmail(dto.email());
        }
        if(dto.especialidade() != null) {
            medico.setEspecialidade(dto.especialidade());
        }

        MedicoEntity updated = medicoRepository.save(medico);
        return toResponseDTO(updated);

    }

    public void delete(Long id){
        if (!medicoRepository.existsById(id)) {
            throw new RuntimeException("usuário não encontrado");
        }
        medicoRepository.deleteById(id);
    }
}