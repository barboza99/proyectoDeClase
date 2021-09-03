package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.una.inventario.dto.TransaccionDTO;
import org.una.inventario.entities.Transaccion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {


    public Optional<Transaccion> findById(Long id);

    public Optional<List<Transaccion>> findByUsuarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate);

    //public Optional<List<Transaccion>> findByRolIdAndFechaCreacionBetween(Long Id, Date startDate, Date endDate);

    public Optional<List<Transaccion>> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate);

    public Optional<List<Transaccion>> findByFechaCreacionBetween(Date startDate, Date endDate);

}
