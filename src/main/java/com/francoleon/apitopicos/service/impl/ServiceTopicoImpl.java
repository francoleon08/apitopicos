package com.francoleon.apitopicos.service.impl;

import com.francoleon.apitopicos.error.DuplicateKeyException;
import com.francoleon.apitopicos.persistence.dto.TopicoDTO;
import com.francoleon.apitopicos.persistence.entity.Topico;
import com.francoleon.apitopicos.persistence.repository.TopicoRepository;
import com.francoleon.apitopicos.service.ServiceTopico;
import com.francoleon.apitopicos.util.ConvertTopicoToTopicoDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceTopicoImpl implements ServiceTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public List<TopicoDTO> getTopicos() {
        return ConvertTopicoToTopicoDTO.convertListTopicosToDTO(topicoRepository.findAll());
    }

    @Override
    @Transactional
    public Optional<Topico> findTopicoById_id(long id) {
        return topicoRepository.findTopicoById_Id(id);
    }

    @Override
    @Transactional
    public Topico saveTopico(Topico topico)  throws DuplicateKeyException {
        try {
            return topicoRepository.save(topico);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateKeyException("Key existente en la base de datos.");
        }
    }

    @Override
    @Transactional
    public void deleteTopicoById_id(long id) {
        topicoRepository.deleteTopicoById_Id(id);
    }
}
