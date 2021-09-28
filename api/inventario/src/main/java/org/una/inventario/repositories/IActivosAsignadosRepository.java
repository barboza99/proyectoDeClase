package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.inventario.dto.ActivosAsignadosDTO;
import org.una.inventario.entities.ActivosAsignados;

import java.util.List;

public interface IActivosAsignadosRepository extends JpaRepository<ActivosAsignados, Long> {

    public List<ActivosAsignadosDTO> findByUsuarioId(Long id);

    public List<ActivosAsignadosDTO> findByActivosId(Long id);

    public List<ActivosAsignadosDTO> findByEstado(boolean estado);

}
