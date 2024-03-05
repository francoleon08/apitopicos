package com.francoleon.apitopicos.persistence.dto;

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
public class TopicoDTO {

    @NotBlank(message = "Ingrese un titulo.")
    private String titulo;
    @NotBlank (message = "Ingrese un mensaje.")
    private String mensaje;
    private String estatus;
    private String autor;
    private String curso;
}
