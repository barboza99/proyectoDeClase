package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlertaDTO {
    private Long id;
    private ActivoDTO activoDTO;
    private String tipo;
    private String descripcion;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long responsable;
}
