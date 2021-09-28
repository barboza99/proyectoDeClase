package org.una.inventario.services;

import org.una.inventario.dto.ExcepcionesDTO;
import org.una.inventario.entities.Excepciones;

import java.util.List;
import java.util.Optional;

public interface IExcepcionesService {

    public Optional<List<ExcepcionesDTO>> findByUsuarioId(Long id);

    public Optional<List<ExcepcionesDTO>> findByEstado(boolean estado);

}
