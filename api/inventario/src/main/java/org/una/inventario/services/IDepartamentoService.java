package org.una.inventario.services;

import org.una.inventario.dto.DepartamentoDTO;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {

    public  Optional<List<DepartamentoDTO>> findByEstado(boolean estado);

}
