package org.una.inventario.dto;


import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RolDTO {
    private Long id;
    private String nombre;
    private Date fechaCreacion;
}
