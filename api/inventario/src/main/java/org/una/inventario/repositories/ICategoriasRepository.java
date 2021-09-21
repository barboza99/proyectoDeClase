package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Categorias;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoriasRepository extends JpaRepository<Categorias, Long> {

    public Optional<List<Categorias>> findByNombreContainingIgnoreCase(String nombre);

    public Optional<List<Categorias>> findByEstado(boolean estado);
}
