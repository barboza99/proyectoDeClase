package org.una.inventario.services;

import org.una.inventario.dto.ContratosGarantiaDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IContratosGarantiasService {

    public Optional<ContratosGarantiaDTO> findById(Long id);

    public Optional<List<ContratosGarantiaDTO>> findByEstadoAndFechaCreacionBetween(boolean estado, Date startDate, Date endDate);

    public Optional<List<ContratosGarantiaDTO>> findByActivosIdAndFechaCreacionBetween(Long id, Date startDate, Date endDate);

}
