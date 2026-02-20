package com.clinicmanager.api.services;

import com.clinicmanager.api.dto.DadosEndereco;
import com.clinicmanager.api.dto.MedicoCreateDTO;
import com.clinicmanager.api.dto.MedicoResponseDTO;
import com.clinicmanager.api.entity.Endereco;
import com.clinicmanager.api.entity.Medico;
import com.clinicmanager.api.repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    private MedicoResponseDTO toResponseDTO(Medico medico) {
        return new MedicoResponseDTO(
                medico.getId(),
                medico.getName(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade(),
                toDadosEndereco(medico.getEndereco())
        );
    }

    private DadosEndereco toDadosEndereco(Endereco endereco) {
        if (endereco == null) return null;

        return new DadosEndereco(
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getNumero(),
                endereco.getComplemento()
        );
    }

    private Endereco toEndereco(DadosEndereco dados) {
        if (dados == null) return null;

        return new Endereco(
                dados.logradouro(),
                dados.bairro(),
                dados.cep(),
                dados.numero(),
                dados.complemento(),
                dados.cidade(),
                dados.uf()
        );
    }

    public MedicoResponseDTO create(MedicoCreateDTO data) {
        Medico medico = new Medico();
        medico.setName(data.name());
        medico.setEmail(data.email());
        medico.setCrm(data.crm());
        medico.setEspecialidade(data.especialidade());
        medico.setEndereco(toEndereco(data.endereco()));

        try {
            Medico saved = medicoRepository.save(medico);
            return toResponseDTO(saved);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("CRM já cadastrado");
        }
    }
}