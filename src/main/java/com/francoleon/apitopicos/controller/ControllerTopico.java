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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
}
