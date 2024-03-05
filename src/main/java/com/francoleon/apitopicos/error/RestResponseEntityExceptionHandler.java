package com.francoleon.apitopicos.error;

import com.francoleon.apitopicos.error.dto.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase para manejar excepciones globales que puedan ocurrir dentro de la aplicación.
 */

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * Método para controlar la exception DuplicateKeyException
     * @param exception exception de clave ya existente en la BD
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErrorMessage> DuplicateKeyException(DuplicateKeyException exception) {
        //Plantilla
        ErrorMessage errorMsg =  new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg);
    }


    /*
     * Sobrecargo el método para poder validar los campos de las entidades.
    */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,Object> errors = new HashMap<>();
        //Recorro la lista de errores producidos al momento de validar con @Valid
        //Los agrego al map y luego los retorno en el cuerpo de la respuesta
        ex.getBindingResult().getFieldErrors().forEach(error ->{
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}


