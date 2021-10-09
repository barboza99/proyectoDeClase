package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Valuacion;

import java.util.List;
import java.util.Optional;

@Repository
public interface IValuacionesRepository extends JpaRepository<Valuacion, Long> {

    public List<Valuacion> findByActivosId(Long id);

    public List<Valuacion> findByInventarioId(Long id);

    @Query(value = "{call calculateValuesOfActivesForInventory(:id_in)}", nativeQuery = true)
    Optional<Valuacion> calculateValuesOfActivesForInventory(@Param("id_in")Long id_in);

    }
