package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.inventario.entities.Excepciones;

import java.util.List;

public interface IExcepcionesRepository extends JpaRepository<Excepciones, Long> {

    public List<Excepciones> findByUsuarioId(Long id);

    public List<Excepciones> findByEstado(boolean estado);
}
