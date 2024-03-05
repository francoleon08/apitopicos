package com.francoleon.apitopicos.controller;

import com.francoleon.apitopicos.error.DuplicateKeyException;
import com.francoleon.apitopicos.persistence.dto.TopicoDTO;
import com.francoleon.apitopicos.persistence.entity.Topico;
import com.francoleon.apitopicos.persistence.entity.TopicoId;
import com.francoleon.apitopicos.service.ServiceTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTopico {

    @Autowired
    private ServiceTopico serviceTopico;

    @PostMapping("/topico")
    public Topico saveTopico(@Valid @RequestBody TopicoDTO topico) throws DuplicateKeyException {
        TopicoId topico_id = TopicoId.builder()
                .titulo(topico.getTitulo())
                .mensaje(topico.getMensaje())
                .build();
        Topico topico_save = Topico.builder()
                .id(topico_id)
                .fecha_crecion(topico.getFecha_crecion())
                .estatus(topico.getEstatus())
                .autor(topico.getAutor())
                .curso(topico.getCurso())
                .build();
        return serviceTopico.saveTopico(topico_save);
    }
}
