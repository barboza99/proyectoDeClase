package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.ContratosGarantias;
import org.una.inventario.entities.Transaccion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IContratosGarantiasRepository extends JpaRepository<ContratosGarantias, Long> {

    public Optional<List<Transaccion>> findByActivosIdAndFechaCreacionBetween(Long activosId, Date startDate, Date endDate);

    public Optional<List<Transaccion>> findByEstadoAndFechaCreacionBetween(boolean estado, Date startDate, Date endDate);

}
