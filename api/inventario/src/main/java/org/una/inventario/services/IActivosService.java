package org.una.inventario.services;

import org.una.inventario.dto.ActivoDTO;

import java.util.List;
import java.util.Optional;

public interface IActivosService {

    public Optional<ActivoDTO>findByNombre(String nombre);

    public Optional<ActivoDTO> findById(Long id);

    public Optional<List<ActivoDTO>> findByCategoriasId(Long id);

    public Optional<List<ActivoDTO>> findByMarcasId(Long id);

    public Optional<List<ActivoDTO>> findByProveedoresId(Long id);
}
