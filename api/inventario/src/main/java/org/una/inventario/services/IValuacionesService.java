package org.una.inventario.services;

import org.una.inventario.dto.ValuacionesDTO;

import java.util.List;
import java.util.Optional;

public interface IValuacionesService {

    public Optional<List<ValuacionesDTO>> findByActivosId(Long id);

    public Optional<List<ValuacionesDTO>> findByInventariosId(Long id);
}
