package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventariosDTO {
    private Long id;
    private Long responsable;
    private String descripcion;
    private boolean estado;
    private Date fechaCreacion;
}
