package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivosAsignadosDTO {
    private Long id;
    private UsuarioDTO usuarioDTO;
    private ActivoDTO activoDTO;
    private String justificacion;
    private boolean estado;
    private Date fechaCreacion;
}
