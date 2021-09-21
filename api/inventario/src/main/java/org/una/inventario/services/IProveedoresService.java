package org.una.inventario.services;

import org.una.inventario.dto.ProveedoresDTO;

import java.util.List;
import java.util.Optional;

public interface IProveedoresService {

    public Optional<ProveedoresDTO> findById(Long id);

    public Optional<List<ProveedoresDTO>> findByNombreAproximateIgnoreCase(String nombre);

    public Optional<List<ProveedoresDTO>> findByEstado(boolean estado);
}
