package org.una.inventario.exceptions;


import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Component
public class PassWordIsBlankException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private final HttpStatus errorCode= HttpStatus.UNAUTHORIZED;

    private final  String errorMessage= "Esta petición no debe llevar contraseña en blanco";


}