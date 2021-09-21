package org.una.inventario.dto;


import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoriasDTO {
    private Long id;
    private String nombre;
    private boolean estado;
    private Date fechaCreacion;
}
