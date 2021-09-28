package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.ExcepcionesDTO;
import org.una.inventario.entities.Excepciones;
import org.una.inventario.repositories.IExcepcionesRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ExcepcionesServiceImplementation implements IExcepcionesService{

    @Autowired
    IExcepcionesRepository excepcionesRepository;

    @Override
    public Optional<List<ExcepcionesDTO>> findByUsuarioId(Long id) {
        List<Excepciones> excepciones = excepcionesRepository.findByUsuarioId(id);
        if(excepciones.isEmpty()) return Optional.empty();
        List<ExcepcionesDTO> resultList = MapperUtils.DtoListFromEntityList(excepciones, ExcepcionesDTO.class);
        return Optional.ofNullable(resultList);
    }

    @Override
    public Optional<List<ExcepcionesDTO>> findByEstado(boolean estado) {
        List<Excepciones> excepciones = excepcionesRepository.findByEstado(estado);
        if(excepciones.isEmpty()) return Optional.empty();
        List<ExcepcionesDTO> resultList = MapperUtils.DtoListFromEntityList(excepciones, ExcepcionesDTO.class);
        return Optional.ofNullable(resultList);
    }
}
