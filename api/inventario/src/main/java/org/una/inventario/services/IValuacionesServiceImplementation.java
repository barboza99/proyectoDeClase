package org.una.inventario.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.ValuacionesDTO;
import org.una.inventario.entities.Valuaciones;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IValuacionesRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class IValuacionesServiceImplementation implements IValuacionesService{

    @Autowired
    IValuacionesRepository valuacionesRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ValuacionesDTO>> findByActivosId(Long id) {
        List<Valuaciones> valuaciones = valuacionesRepository.findByActivosId(id);
        if(valuaciones.isEmpty()) throw new NotFoundInformationException();
        List<ValuacionesDTO> valuacionesDTO = MapperUtils.DtoListFromEntityList(valuaciones, ValuacionesDTO.class);
        return Optional.ofNullable(valuacionesDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ValuacionesDTO>> findByInventariosId(Long id) {
        List<Valuaciones> valuaciones = valuacionesRepository.findByInventariosId(id);
        if(valuaciones.isEmpty()) throw new NotFoundInformationException();
        List<ValuacionesDTO> valuacionesDTO = MapperUtils.DtoListFromEntityList(valuaciones, ValuacionesDTO.class);
        return Optional.ofNullable(valuacionesDTO);
    }
}
