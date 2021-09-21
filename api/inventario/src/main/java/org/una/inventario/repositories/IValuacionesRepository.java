package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Valuaciones;

import java.util.List;
import java.util.Optional;

@Repository
public interface IValuacionesRepository extends JpaRepository<Valuaciones, Long> {

    public List<Valuaciones> findByActivosId(Long id);

    public List<Valuaciones> findByInventariosId(Long id);
}
