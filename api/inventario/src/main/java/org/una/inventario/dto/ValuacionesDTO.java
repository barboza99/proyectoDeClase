package org.una.inventario.dto;

import lombok.*;

import java.util.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ValuacionesDTO {
    private Long id;
    private InventariosDTO inventariosDTO;
    private double precioValuacion;
    private Date fechaCreacion;
    private ActivoDTO activoDTO;
}
