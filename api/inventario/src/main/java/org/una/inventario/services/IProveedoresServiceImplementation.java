package org.una.inventario.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.ProveedoresDTO;
import org.una.inventario.entities.Proveedores;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IProveedoresRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class IProveedoresServiceImplementation implements IProveedoresService{

    @Autowired
    IProveedoresRepository proveedoresRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<ProveedoresDTO> findById(Long id) {
        Optional<Proveedores> proveedor = proveedoresRepository.findById(id);
        if(proveedor.isEmpty()) throw new NotFoundInformationException();
        ProveedoresDTO proveedorDTO = MapperUtils.DtoFromEntity(proveedor, ProveedoresDTO.class);
        return Optional.ofNullable(proveedorDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProveedoresDTO>> findByNombreAproximateIgnoreCase(String nombre) {
        Optional<List<Proveedores>> proveedores = proveedoresRepository.findByNombreContainingIgnoreCase(nombre);
        if(proveedores.isEmpty()) throw new NotFoundInformationException();
        List<ProveedoresDTO> proveedoresDTO = MapperUtils.DtoListFromEntityList(proveedores.get(), ProveedoresDTO.class);
        return Optional.ofNullable(proveedoresDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProveedoresDTO>> findByEstado(boolean estado) {
        Optional<List<Proveedores>> proveedores = proveedoresRepository.findByEstado(estado);
        if(proveedores.isEmpty()) throw new NotFoundInformationException();
        List<ProveedoresDTO> proveedoresDTO = MapperUtils.DtoListFromEntityList(proveedores.get(), ProveedoresDTO.class);
        return Optional.ofNullable(proveedoresDTO);
    }
}
