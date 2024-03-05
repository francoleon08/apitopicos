package com.francoleon.apitopicos.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"id_titulo", "id_mensaje"})
})
public class Topico {

    @EmbeddedId
    private TopicoId id;
    private Date fecha_crecion;
    private String estatus;
    private String autor;
    private String curso;
}
