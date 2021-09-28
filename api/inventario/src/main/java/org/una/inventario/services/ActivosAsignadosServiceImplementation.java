package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.ActivosAsignadosDTO;
import org.una.inventario.repositories.IActivosAsignadosRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ActivosAsignadosServiceImplementation implements IActivosAsignadosService {

    @Autowired
    IActivosAsignadosRepository activosAsignadosRepository;

    @Override
    public Optional<List<ActivosAsignadosDTO>> findByUsuarioId(Long id) {
        List<ActivosAsignadosDTO> activosAsignados = activosAsignadosRepository.findByUsuarioId(id);
        if(activosAsignados.isEmpty()) return Optional.empty();
        List<ActivosAsignadosDTO> resultList = MapperUtils.DtoListFromEntityList(activosAsignados, ActivosAsignadosDTO.class);
        return Optional.ofNullable(resultList);
    }

    @Override
    public  Optional<List<ActivosAsignadosDTO>> findByActivosId(Long id) {
        List<ActivosAsignadosDTO> activosAsignados = activosAsignadosRepository.findByActivosId(id);
        if(activosAsignados.isEmpty()) return Optional.empty();
        List<ActivosAsignadosDTO> resultList = MapperUtils.DtoListFromEntityList(activosAsignados, ActivosAsignadosDTO.class);
        return Optional.ofNullable(resultList);
    }

    @Override
    public  Optional<List<ActivosAsignadosDTO>> findByEstado(boolean estado) {
        List<ActivosAsignadosDTO> activosAsignados = activosAsignadosRepository.findByEstado(estado);
        if(activosAsignados.isEmpty()) return Optional.empty();
        List<ActivosAsignadosDTO> resultList = MapperUtils.DtoListFromEntityList(activosAsignados, ActivosAsignadosDTO.class);
        return Optional.ofNullable(resultList);
    }
}
