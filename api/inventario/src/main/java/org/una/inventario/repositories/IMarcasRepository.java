package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Marcas;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMarcasRepository extends JpaRepository<Marcas, Long> {

    public Optional<List<Marcas>> findByNombreContainingIgnoreCase(String nombre);

    public Optional<List<Marcas>> findByEstado(boolean estado);
}
