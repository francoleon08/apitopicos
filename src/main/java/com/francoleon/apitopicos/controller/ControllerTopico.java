package com.francoleon.apitopicos.controller;

import com.francoleon.apitopicos.error.DuplicateKeyException;
import com.francoleon.apitopicos.persistence.dto.TopicoDTO;
import com.francoleon.apitopicos.persistence.entity.Topico;
import com.francoleon.apitopicos.persistence.entity.TopicoId;
import com.francoleon.apitopicos.service.ServiceTopico;
import com.francoleon.apitopicos.util.ConvertTopicoToTopicoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerTopico {

    @Autowired
    private ServiceTopico serviceTopico;

    /**
     * Endpoint para guardar un topico
     * @param topico
     * @return ResponseEntity contiene el topico almacenado
     * @throws DuplicateKeyException excepcion para controlar el almacenamiento de claves duplicadas
     */
    @PostMapping("/topico")
    public ResponseEntity<Topico> saveTopico(@Valid @RequestBody TopicoDTO topico) throws DuplicateKeyException {
        topico.setFecha_crecion(new Date());
        return ResponseEntity.ok(serviceTopico.saveTopico(ConvertTopicoToTopicoDTO.convertTopicoDTOToTopico(topico)));
    }

    /**
     * Endopint para obtener todoso los Topicos almacenados
     * @return ResponseEntity contiene una lista de TopicosDTO almacenados
     */
    @GetMapping("/topicos")
    public ResponseEntity<List<TopicoDTO>> getTopicos() {
        List<TopicoDTO> list = serviceTopico.getTopicos();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    /**
     * Endpoint para buscar un Topico mediante si long id
     * @param id del Topico
     * @return ResponseEntity que contiene los detalles del Topico buscado
     */
    @GetMapping("/topico/{id}")
    public ResponseEntity<TopicoDTO> findTopicoById_id(@PathVariable long id) {
        Optional<Topico> topico = serviceTopico.findTopicoById_id(id);
        return topico.map(
                value -> ResponseEntity.ok(ConvertTopicoToTopicoDTO.convertTopicoToDTO(value))).orElseGet(()
                -> ResponseEntity.noContent().build());
    }


    /**
     * Enpoint para actualizar un Topico registrado.
     * Campos obligatorios : {autor, curso, titulo, mensaje}
     * @param id del Topico a actualizar
     * @param topicoDTO
     * @return
     * @throws DuplicateKeyException exception de clave duplicada
     */
    @PutMapping("/topico/{id}")
    public ResponseEntity<Topico> updateTopico(
            @PathVariable long id,
            @Valid @RequestBody TopicoDTO topicoDTO) throws DuplicateKeyException {
        Optional<Topico> topico = serviceTopico.findTopicoById_id(id);
        Topico update;
        TopicoId updateId;

        if(topico.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Actualizo el ID
        updateId = TopicoId.builder()
                .id(topico.get().getId().getId())
                .mensaje(topicoDTO.getMensaje())
                .titulo(topicoDTO.getTitulo())
                .build();

        // Actualizo el Topico
        update = Topico.builder()
                .id(updateId)
                .autor(topicoDTO.getAutor())
                .curso(topicoDTO.getCurso())
                .estatus(topico.get().getEstatus())
                .fecha_crecion(topico.get().getFecha_crecion())
                .build();

        return ResponseEntity.ok(serviceTopico.saveTopico(update));
    }


    /**
     * Endpoint para eliminar un registro mediante su id
     * @param id
     */
    @DeleteMapping("/topico/{id}")
    public void deleteTopicoById(@PathVariable long id) {
        serviceTopico.deleteTopicoById_id(id);
    }
}
