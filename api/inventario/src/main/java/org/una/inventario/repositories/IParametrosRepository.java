package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.servlet.tags.ParamTag;
import org.una.inventario.entities.Parametros;

import java.util.List;
import java.util.Optional;

public interface IParametrosRepository extends JpaRepository<Parametros, Long>{

    public List<Parametros> findAll();

    public Optional<Parametros> findByNombre(String nombre);

}
