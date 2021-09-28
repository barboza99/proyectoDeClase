package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Categoria;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoriasRepository extends JpaRepository<Categoria, Long> {

    public Optional<List<Categoria>> findByNombreContainingIgnoreCase(String nombre);

    public Optional<List<Categoria>> findByEstado(boolean estado);
}
