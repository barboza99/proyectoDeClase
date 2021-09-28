package org.una.inventario.services;

import org.una.inventario.dto.CategoriasDTO;

import java.util.List;
import java.util.Optional;

public interface ICategoriasService {

    public Optional<List<CategoriasDTO>> findByNombreAproximate(String nombre);

    public Optional<List<CategoriasDTO>> findByEstado(boolean estado);

}
