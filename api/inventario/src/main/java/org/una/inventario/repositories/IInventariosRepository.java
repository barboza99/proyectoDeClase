package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Inventarios;

@Repository
public interface IInventariosRepository extends JpaRepository<Inventarios, Long> {
}
