package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Alertas;

import java.util.Optional;

@Repository
public interface IAlertasRepository extends JpaRepository<Alertas, Long> {
    public Optional<Alertas> findByEstado(boolean estado);
}
