package org.una.inventario.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.entities.Activos;

import java.util.List;
import java.util.Optional;

@Repository
public interface IActivosRepository extends JpaRepository<Activos, Long> {

    public Optional<Activos> findByNombre(String nombre);

    public Optional<List<Activos>> findByCategoriaId(Long id);

    public Optional<List<Activos>> findByMarcaId(Long id);

    public Optional<List<Activos>> findByProveedorId(Long id);

}
