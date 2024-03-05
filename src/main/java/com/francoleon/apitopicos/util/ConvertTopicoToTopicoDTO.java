package com.francoleon.apitopicos.util;

import com.francoleon.apitopicos.persistence.dto.TopicoDTO;
import com.francoleon.apitopicos.persistence.entity.Topico;
import com.francoleon.apitopicos.persistence.entity.TopicoId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConvertTopicoToTopicoDTO {

    /**
     * Convierte una lista de Topicos a una lista de TopicosDTO
     * @param topicos
     * @return
     */
    public static List<TopicoDTO> convertListTopicosToDTO(List<Topico> topicos) {
        List<TopicoDTO> list_topicosDTO = new ArrayList<>();
        topicos.forEach(topico -> {
            list_topicosDTO.add(convertTopicoToDTO(topico));
        });
        return list_topicosDTO;
    }


    /**
     * Convierte un Topico en un TopicoDTO
     * @param topico
     * @return
     */
    public static TopicoDTO convertTopicoToDTO(Topico topico) {
        return TopicoDTO.builder()
                .titulo(topico.getId().getTitulo())
                .mensaje(topico.getId().getMensaje())
                .autor(topico.getAutor())
                .curso(topico.getCurso())
                .estatus(topico.getEstatus())
                .fecha_crecion(topico.getFecha_crecion())
                .build();
    }

    /**
     * Convierte un TopicoDTO en un Topico
     * @param topico TopicoDTO
     * @return Topico
     */
    public static Topico convertTopicoDTOToTopico(TopicoDTO topico) {
        TopicoId topico_id = TopicoId.builder()
                .titulo(topico.getTitulo())
                .mensaje(topico.getMensaje())
                .build();
        return Topico.builder()
                .id(topico_id)
                .fecha_crecion(topico.getFecha_crecion())
                .estatus(topico.getEstatus())
                .autor(topico.getAutor())
                .curso(topico.getCurso())
                .build();
    }
}
