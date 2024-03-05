package com.francoleon.apitopicos.persistence.repository;

import com.francoleon.apitopicos.persistence.entity.Topico;
import com.francoleon.apitopicos.persistence.entity.TopicoId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TopicoRepositoryTest {

    @Autowired
    private TopicoRepository topicoRepository;

    @Test
    public void saveTopico() {
        TopicoId topicoId = TopicoId.builder()
                .titulo("Topico 2")
                .mensaje("Mensaje topico 2")
                .build();
        Topico topico = Topico.builder()
                .id(topicoId)
                .fecha_crecion(new Date())
                .estatus("en proceso")
                .autor("Federico")
                .curso("Alura")
                .build();
        topicoRepository.save(topico);
    }
}