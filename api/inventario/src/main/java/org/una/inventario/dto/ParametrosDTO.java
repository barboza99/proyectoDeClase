package org.una.inventario.dto;

import lombok.*;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParametrosDTO {
    private Long id;
    private String valor;
    private String nombre;
    private boolean estado;
    private Date fechaCreacion;
    private  Date fechaModificacion;

}
