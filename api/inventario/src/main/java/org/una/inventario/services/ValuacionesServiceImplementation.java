package org.una.inventario.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.ValuacionesDTO;
import org.una.inventario.entities.Valuacion;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IValuacionesRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ValuacionesServiceImplementation implements IValuacionesService{

    @Autowired
    IValuacionesRepository valuacionesRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ValuacionesDTO>> findByActivosId(Long id) {
        List<Valuacion> valuaciones = valuacionesRepository.findByActivosId(id);
        if(valuaciones.isEmpty()) throw new NotFoundInformationException();
        List<ValuacionesDTO> valuacionesDTO = MapperUtils.DtoListFromEntityList(valuaciones, ValuacionesDTO.class);
        return Optional.ofNullable(valuacionesDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ValuacionesDTO>> findByInventariosId(Long id) {
        List<Valuacion> valuaciones = valuacionesRepository.findByInventarioId(id);
        if(valuaciones.isEmpty()) throw new NotFoundInformationException();
        List<ValuacionesDTO> valuacionesDTO = MapperUtils.DtoListFromEntityList(valuaciones, ValuacionesDTO.class);
        return Optional.ofNullable(valuacionesDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ValuacionesDTO> findByIdDeInventarios(Long id) {
        Optional<Valuacion> valuacion = valuacionesRepository.calculateValuesOfActivesForInventory(id);
        if(!valuacion.isPresent()) throw new NotFoundInformationException();
        ValuacionesDTO valuacionDTO = MapperUtils.DtoFromEntity(valuacion.get() , ValuacionesDTO.class);
        return Optional.ofNullable(valuacionDTO);

    }

}
