package org.una.inventario.services;

import org.una.inventario.dto.AlertaDTO;

import java.util.Optional;

public interface IAlertasService {
    public Optional<AlertaDTO> findById(Long id);

    public Optional<AlertaDTO> findByEstado(boolean estado);
}



