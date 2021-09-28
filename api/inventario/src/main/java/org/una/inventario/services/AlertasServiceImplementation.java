package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.AlertaDTO;
import org.una.inventario.entities.Alertas;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IAlertasRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.Optional;

@Service
public class AlertasServiceImplementation implements IAlertasService{

    @Autowired
    IAlertasRepository alertasRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<AlertaDTO> findById(Long id) {
        Optional<Alertas> alerta = alertasRepository.findById(id);
        if(alerta.isEmpty()) throw new NotFoundInformationException();
        AlertaDTO alertaDTO = MapperUtils.DtoFromEntity(alerta, AlertaDTO.class);
        return Optional.ofNullable(alertaDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AlertaDTO> findByEstado(boolean estado) {
        Optional<Alertas> alerta = alertasRepository.findByEstado(estado);
        if(alerta.isEmpty()) throw new NotFoundInformationException();
        AlertaDTO alertaDTO = MapperUtils.DtoFromEntity(alerta, AlertaDTO.class);
        return Optional.ofNullable(alertaDTO);
    }
}
