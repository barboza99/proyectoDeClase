package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.DepartamentoDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.entities.Departamento;
import org.una.inventario.entities.Usuario;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IDepartamentoRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServiceImplementation implements  IDepartamentoService{

    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<DepartamentoDTO> findById(Long id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isEmpty()) throw new NotFoundInformationException();
        DepartamentoDTO departamentoDTO = MapperUtils.DtoFromEntity(departamento, DepartamentoDTO.class);
        return Optional.ofNullable(departamentoDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<DepartamentoDTO>> findAll() {
        List<DepartamentoDTO> departamentoDTOList = MapperUtils.DtoListFromEntityList(departamentoRepository.findAll(), DepartamentoDTO.class);
        return Optional.ofNullable(departamentoDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<DepartamentoDTO>> findByEstado(boolean estado) {
        List<Departamento> departamentoList = departamentoRepository.findByEstado(estado);
        if(departamentoList.isEmpty()) throw new NotFoundInformationException();

        List<DepartamentoDTO> departamentoDTOList = MapperUtils.DtoListFromEntityList(departamentoList, DepartamentoDTO.class);
        return Optional.ofNullable(departamentoDTOList);

    }

    private DepartamentoDTO getSavedUsuarioDTO(DepartamentoDTO departamentoDTO) {
        Departamento departamento = MapperUtils.EntityFromDto(departamentoDTO, Departamento.class);
        Departamento departamentoCreated = departamentoRepository.save(departamento);
        return MapperUtils.DtoFromEntity(departamentoCreated, DepartamentoDTO.class);
    }

    @Override
    public Optional<DepartamentoDTO> create(DepartamentoDTO departamentoDTO) {
        return Optional.ofNullable(getSavedUsuarioDTO(departamentoDTO));
    }



}