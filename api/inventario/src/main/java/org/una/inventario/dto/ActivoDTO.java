package org.una.inventario.dto;

import lombok.*;
import org.una.inventario.entities.Categorias;
import org.una.inventario.entities.Marcas;
import org.una.inventario.entities.Proveedores;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivoDTO {
    private Long id;
    private CategoriasDTO categorias;
    private MarcasDTO marcas;
    private ProveedoresDTO proveedores;
    private double continente;
    private String nombre;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;

}
