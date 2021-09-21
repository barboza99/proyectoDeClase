package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.ActivoDTO;
import org.una.inventario.entities.Activo;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IActivosRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

public class IActivosServiceImplementation implements IActivosService{

    @Autowired
    private IActivosRepository activosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<ActivoDTO> findByNombre(String nombre) {
        Optional<Activo> activo = activosRepository.findByNombre(nombre);
        if(activo.isEmpty()) throw new NotFoundInformationException();
        ActivoDTO activosDTO = MapperUtils.DtoFromEntity(activo, ActivoDTO.class);
        return Optional.ofNullable(activosDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ActivoDTO> findById(Long id) {
        Optional<Activo> activo = activosRepository.findById(id);
        if(activo.isEmpty()) throw new NotFoundInformationException();
        ActivoDTO activoDTO = MapperUtils.DtoFromEntity(activo, ActivoDTO.class);
        return Optional.ofNullable(activoDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ActivoDTO>> findByCategoriasId(Long id) {
        Optional<List<Activo>> activos = activosRepository.findByCategoriasId(id);
        if(activos.isEmpty()) throw new NotFoundInformationException();
        List<ActivoDTO> activosDTO = MapperUtils.DtoListFromEntityList(activos.get(), ActivoDTO.class);
        return Optional.ofNullable(activosDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ActivoDTO>> findByMarcasId(Long id) {
        Optional<List<Activo>> activos = activosRepository.findByMarcasId(id);
        if(activos.isEmpty()) throw new NotFoundInformationException();
        List<ActivoDTO> activosDTO = MapperUtils.DtoListFromEntityList(activos.get(), ActivoDTO.class);
        return Optional.ofNullable(activosDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ActivoDTO>> findByProveedoresId(Long id) {
        Optional<List<Activo>> activos = activosRepository.findByProveedoresId(id);
        if(activos.isEmpty()) throw new NotFoundInformationException();
        List<ActivoDTO> activosDTO = MapperUtils.DtoListFromEntityList(activos.get(), ActivoDTO.class);
        return Optional.ofNullable(activosDTO);
    }


}
