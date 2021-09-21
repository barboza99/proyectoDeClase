package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContratosGarantiaDTO {
    private Long id;
    private ActivoDTO activoDTO;
    private double montoAsegurado;
    private double costo;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String fechaVencimiento;
}
