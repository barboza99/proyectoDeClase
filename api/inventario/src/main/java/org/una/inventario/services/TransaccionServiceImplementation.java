package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.TransaccionDTO;
import org.una.inventario.entities.Transaccion;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.ITransaccionRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImplementation implements ITransaccionService{

    @Autowired
    private ITransaccionRepository transaccionRepository;

    @Override
    public Optional<TransaccionDTO> findById(Long id) {
        Optional<Transaccion> transaccion = transaccionRepository.findById(id);
        if(transaccion.isEmpty()) throw new NotFoundInformationException();
        TransaccionDTO transaccionDTO = MapperUtils.DtoFromEntity(transaccion.get(), TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTO);
    }

    @Override
    public Optional<List<TransaccionDTO>> findByUsuarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate) {
            Optional<List<Transaccion>> transaccionList = transaccionRepository.findByUsuarioIdAndFechaCreacionBetween(usuarioId, startDate, endDate);
            if(transaccionList.isEmpty()) throw new NotFoundInformationException();
            List<TransaccionDTO> transaccionDTO = MapperUtils.DtoListFromEntityList(transaccionList.get(), TransaccionDTO.class);
            return Optional.ofNullable(transaccionDTO);
    }

    /*@Override
    public Optional<List<TransaccionDTO>> findByRolIdAndFechaCreacionBetween(Long rolId, Date startDate, Date endDate) {
        Optional<List<Transaccion>> transaccionList = transaccionRepository.findByRolIdAndFechaCreacionBetween(rolId, startDate, endDate);
        if(transaccionList.isEmpty()) throw new NotFoundInformationException();
        List<TransaccionDTO> transaccionDTOList = MapperUtils.EntityListFromDtoList(transaccionList.get(), TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTOList);
    }*/

    @Override
    public Optional<List<TransaccionDTO>> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate) {
        Optional<List<Transaccion>> transaccionList = transaccionRepository.findByObjetoAndFechaCreacionBetween(objetoId, startDate, endDate);
        if(transaccionList.isEmpty()) throw new NotFoundInformationException();
        List<TransaccionDTO> transaccionDTOList = MapperUtils.EntityListFromDtoList(transaccionList.get(), TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTOList);
    }

    @Override
    public Optional<List<TransaccionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate) {
        Optional<List<Transaccion>> transaccionList = transaccionRepository.findByFechaCreacionBetween(startDate, endDate);
        if(transaccionList.isEmpty()) throw new NotFoundInformationException();
        List<TransaccionDTO> transaccionDTOList = MapperUtils.EntityListFromDtoList(transaccionList.get(), TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTOList);
    }

    private TransaccionDTO getSavedTransaccionDto(TransaccionDTO transaccionDTO) {
       Transaccion transaccion = MapperUtils.EntityFromDto(transaccionDTO, Transaccion.class);
        Transaccion transaccion1 = transaccionRepository.save(transaccion);
        return MapperUtils.DtoFromEntity(transaccion1, TransaccionDTO.class);
    }

    @Override
    public Optional<TransaccionDTO> create(TransaccionDTO transaccionDTO) {
        return Optional.ofNullable(getSavedTransaccionDto(transaccionDTO));
    }
}
