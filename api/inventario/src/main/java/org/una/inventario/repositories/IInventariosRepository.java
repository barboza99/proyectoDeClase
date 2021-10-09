package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Inventario;

import java.util.List;

@Repository
public interface IInventariosRepository extends JpaRepository<Inventario, Long> {

    public List<Inventario> findByEstado(boolean estado);

    public List<Inventario> findByResponsable(Long id);

}
