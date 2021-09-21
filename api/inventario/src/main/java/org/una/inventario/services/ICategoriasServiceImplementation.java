package org.una.inventario.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.CategoriasDTO;
import org.una.inventario.entities.Categorias;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.ICategoriasRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ICategoriasServiceImplementation implements ICategoriasService{

    @Autowired
    ICategoriasRepository categoriasRepository;


    @Override
    @Transactional(readOnly = true)
    public Optional<List<CategoriasDTO>> findByNombreAproximate(String nombre) {
        Optional<List<Categorias>> categorias = categoriasRepository.findByNombreContainingIgnoreCase(nombre);
        if(categorias.isEmpty()) throw new NotFoundInformationException();
        List<CategoriasDTO> categoriasDTO = MapperUtils.DtoListFromEntityList(categorias.get(), CategoriasDTO.class);
        return Optional.ofNullable(categoriasDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CategoriasDTO>> findByEstado(boolean estado) {
        Optional<List<Categorias>> categorias = categoriasRepository.findByEstado(estado);
        if(categorias.isEmpty()) throw new NotFoundInformationException();
        List<CategoriasDTO> categoriasDTO = MapperUtils.DtoListFromEntityList(categorias.get(), CategoriasDTO.class);
        return Optional.ofNullable(categoriasDTO);
    }
}
