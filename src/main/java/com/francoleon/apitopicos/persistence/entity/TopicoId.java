package com.francoleon.apitopicos.persistence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class TopicoId implements Serializable {

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topico_seq"
    )
    @SequenceGenerator(
            name = "topico_seq",
            sequenceName = "topico_sequence",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "id_titulo")
    private String titulo;
    @Column(name = "id_mensaje")
    private String mensaje;
}
