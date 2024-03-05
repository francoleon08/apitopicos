package com.francoleon.apitopicos.service;

import com.francoleon.apitopicos.error.DuplicateKeyException;
import com.francoleon.apitopicos.persistence.dto.TopicoDTO;
import com.francoleon.apitopicos.persistence.entity.Topico;

import java.util.List;

public interface ServiceTopico {

    /**
     * Recupera una lista de TopicosDTO almacenados
     * @return List<TopicoDTO> lista de topicos
     */
    public List<TopicoDTO> getTopicos();

    /**
     * Registra un Topico
     * @param topico
     * @return Topico almacenado
     * @throws DuplicateKeyException exception de clave ya existente.
     */
    public Topico saveTopico(Topico topico) throws DuplicateKeyException;
}
