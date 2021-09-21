package org.una.inventario.services;

import org.una.inventario.dto.MarcasDTO;

import java.util.List;
import java.util.Optional;

public interface IMarcasService {

    public Optional<List<MarcasDTO>> findByNombreAproximateIgnoreCase(String nombre);

    public Optional<List<MarcasDTO>> findByEstado(boolean estado);
}
