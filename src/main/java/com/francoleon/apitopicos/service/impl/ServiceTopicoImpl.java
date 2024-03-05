package com.francoleon.apitopicos.service.impl;

import com.francoleon.apitopicos.error.DuplicateKeyException;
import com.francoleon.apitopicos.persistence.entity.Topico;
import com.francoleon.apitopicos.persistence.repository.TopicoRepository;
import com.francoleon.apitopicos.service.ServiceTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class ServiceTopicoImpl implements ServiceTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public Topico saveTopico(Topico topico)  throws DuplicateKeyException {
        try {
            return topicoRepository.save(topico);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateKeyException("Key existente en la base de datos.");
        }
    }
}
