package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.inventario.entities.Departamento;

import java.util.List;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {

    public List<Departamento> findByEstado(boolean estado);

}
