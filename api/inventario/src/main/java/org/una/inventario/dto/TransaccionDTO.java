package org.una.inventario.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransaccionDTO {
    private Long id;
    private String objeto;
    private String accion;
    private Date fechaCreacion;

}
