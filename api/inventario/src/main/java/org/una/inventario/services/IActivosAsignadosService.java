package org.una.inventario.services;

import org.una.inventario.dto.ActivosAsignadosDTO;

import java.util.List;
import java.util.Optional;

public interface IActivosAsignadosService {

    public Optional<List<ActivosAsignadosDTO>> findByUsuarioId(Long id);

    public Optional<List<ActivosAsignadosDTO>> findByActivosId(Long id);

    public Optional<List<ActivosAsignadosDTO>> findByEstado(boolean estado);

}
