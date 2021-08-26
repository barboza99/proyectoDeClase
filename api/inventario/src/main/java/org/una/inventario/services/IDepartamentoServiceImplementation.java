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
import org.una.inventario.repositories.IUsuarioRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

public class IDepartamentoServiceImplementation  implements  IDepartamentoService{

    private IDepartamentoRepository departamentoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<DepartamentoDTO>> findByEstado(boolean estado) {
        List<Departamento> departamentoList = departamentoRepository.findByEstado(estado);
        if(departamentoList.isEmpty()) throw new NotFoundInformationException();

        List<DepartamentoDTO> departamentoDTOList = MapperUtils.DtoListFromEntityList(departamentoList, DepartamentoDTO.class);
        return Optional.ofNullable(departamentoDTOList);

    }

}
