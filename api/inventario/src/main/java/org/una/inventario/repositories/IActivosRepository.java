package org.una.inventario.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Activo;

import java.util.List;
import java.util.Optional;

@Repository
public interface IActivosRepository extends JpaRepository<Activo, Long> {

    public Optional<Activo> findByNombre(String nombre);

    public Optional<List<Activo>> findByCategoriasId(Long id);

    public Optional<List<Activo>> findByMarcasId(Long id);

    public Optional<List<Activo>> findByProveedoresId(Long id);

}
