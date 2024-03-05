package com.francoleon.apitopicos.service;

import com.francoleon.apitopicos.error.DuplicateKeyException;
import com.francoleon.apitopicos.persistence.dto.TopicoDTO;
import com.francoleon.apitopicos.persistence.entity.Topico;

import java.util.List;
import java.util.Optional;

public interface ServiceTopico {

    /**
     * Recupera una lista de TopicosDTO almacenados
     * @return List<TopicoDTO> lista de topicos
     */
    public List<TopicoDTO> getTopicos();

    /**
     * Recupera un topico por su long id
     * @param id del topico
     * @return Topico
     */
    public Optional<Topico> findTopicoById_id(long id);

    /**
     * Registra un Topico
     * @param topico
     * @return Topico almacenado
     * @throws DuplicateKeyException exception de clave ya existente.
     */
    public Topico saveTopico(Topico topico) throws DuplicateKeyException;

    /**
     * Elimina un registro de la base de datos mediante su id
     * @param id del topico
     */
    public void deleteTopicoById_id(long id);
}
