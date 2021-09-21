package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Proveedores;
import org.una.inventario.entities.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProveedoresRepository extends JpaRepository<Proveedores, Long> {
    public Optional<List<Proveedores>> findByNombreContainingIgnoreCase(String nombre);

    public Optional<List<Proveedores>> findByEstado(boolean estado);
}
