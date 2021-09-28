package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Proveedor;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProveedoresRepository extends JpaRepository<Proveedor, Long> {
    public Optional<List<Proveedor>> findByNombreContainingIgnoreCase(String nombre);

    public Optional<List<Proveedor>> findByEstado(boolean estado);
}
