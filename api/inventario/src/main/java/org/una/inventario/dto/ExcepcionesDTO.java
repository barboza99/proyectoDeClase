package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExcepcionesDTO {
    private Long id;
    private UsuarioDTO usuarioDTO;
    private String descripcion;
    private boolean estado;
    private Date fechaCreacion;
}
