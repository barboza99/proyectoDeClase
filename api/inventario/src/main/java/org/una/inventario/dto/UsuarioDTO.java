package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioDTO  {

    private Long id;
    private String nombreCompleto;
    private String passwordEncriptado;
    private String cedula;
    private boolean estado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private DepartamentoDTO departamento;
    private boolean esJefe;
    private RolDTO rol;
}

