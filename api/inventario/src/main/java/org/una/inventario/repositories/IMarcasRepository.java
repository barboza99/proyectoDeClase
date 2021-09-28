package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Marca;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMarcasRepository extends JpaRepository<Marca, Long> {

    public Optional<List<Marca>> findByNombreContainingIgnoreCase(String nombre);

    public Optional<List<Marca>> findByEstado(boolean estado);
}
