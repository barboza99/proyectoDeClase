package org.una.inventario.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Component
public class UsernameNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private final HttpStatus errorCode= HttpStatus.FORBIDDEN;

    //private final  String errorMessage= "Error en la petición, credenciales incorrectas";
}