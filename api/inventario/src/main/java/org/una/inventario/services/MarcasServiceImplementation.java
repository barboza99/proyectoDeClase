package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.MarcasDTO;
import org.una.inventario.entities.Marca;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IMarcasRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class MarcasServiceImplementation implements IMarcasService{

    @Autowired
    IMarcasRepository marcasRepository;

    @Override
    public Optional<List<MarcasDTO>> findByNombreAproximateIgnoreCase(String nombre) {
        Optional<List<Marca>> marcas = marcasRepository.findByNombreContainingIgnoreCase(nombre);
        if(marcas.isEmpty()) throw new NotFoundInformationException();
        List<MarcasDTO> marcasDTO = MapperUtils.DtoListFromEntityList(marcas.get(), MarcasDTO.class);
        return Optional.ofNullable(marcasDTO);
    }

    @Override
    public Optional<List<MarcasDTO>> findByEstado(boolean estado) {
        Optional<List<Marca>> marcas = marcasRepository.findByEstado(estado);
        if(marcas.isEmpty()) throw new NotFoundInformationException();
        List<MarcasDTO> marcasDTO = MapperUtils.DtoListFromEntityList(marcas.get(), MarcasDTO.class);
        return Optional.ofNullable(marcasDTO);
    }
}
