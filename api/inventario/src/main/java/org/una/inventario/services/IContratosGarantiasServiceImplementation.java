package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.ContratosGarantiaDTO;
import org.una.inventario.entities.ContratosGarantias;
import org.una.inventario.entities.Transaccion;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IContratosGarantiasRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class IContratosGarantiasServiceImplementation implements IContratosGarantiasService{

    @Autowired
    IContratosGarantiasRepository contratosGarantiasRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<ContratosGarantiaDTO> findById(Long id) {
        Optional<ContratosGarantias> contratoGarantia = contratosGarantiasRepository.findById(id);
        if(contratoGarantia.isEmpty()) throw new NotFoundInformationException();
        ContratosGarantiaDTO contratosGarantiaDTO = MapperUtils.DtoFromEntity(contratoGarantia, ContratosGarantiaDTO.class);
        return Optional.ofNullable(contratosGarantiaDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ContratosGarantiaDTO>> findByEstadoAndFechaCreacionBetween(boolean estado, Date startDate, Date endDate) {
        Optional<List<Transaccion>> contratoGarantia = contratosGarantiasRepository.findByEstadoAndFechaCreacionBetween(estado, startDate, endDate);
        if(contratoGarantia.isEmpty()) throw new NotFoundInformationException();
        List <ContratosGarantiaDTO> contratosGarantiaDTO = MapperUtils.DtoListFromEntityList(contratoGarantia.get(), ContratosGarantiaDTO.class);
        return Optional.ofNullable(contratosGarantiaDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ContratosGarantiaDTO>> findByActivosIdAndFechaCreacionBetween(Long id, Date startDate, Date endDate) {
        Optional<List<Transaccion>> contratoGarantia = contratosGarantiasRepository.findByActivosIdAndFechaCreacionBetween(id, startDate, endDate);
        if(contratoGarantia.isEmpty()) throw new NotFoundInformationException();
        List <ContratosGarantiaDTO> contratosGarantiaDTO = MapperUtils.DtoListFromEntityList(contratoGarantia.get(), ContratosGarantiaDTO.class);
        return Optional.ofNullable(contratosGarantiaDTO);
    }
}
