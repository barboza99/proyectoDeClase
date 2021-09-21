package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProveedoresDTO {
    private Long id;
    private String nombre;
    private String notas;
    private String telefono;
    private String correoElectronico;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
}
