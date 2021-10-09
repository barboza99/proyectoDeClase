package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ValuacionesDTO;
import org.una.inventario.services.IValuacionesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/valuaciones")
@Api(tags = {"Valuaciones"})
public class ValuacionController {

    @Autowired
    IValuacionesService valuacionesService;

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @GetMapping("/id/{id}")
    @ApiOperation(value = "Obtiene una valuacion a partir de un id de inventario", response = ValuacionesDTO.class
    , tags = "Valuaciones")
    public ResponseEntity<?> findByInventarioId(@PathVariable(value = "id")Long id) {
        Optional<ValuacionesDTO> valuacionesDTO = valuacionesService.findByIdDeInventarios(id);
        return new ResponseEntity<>(valuacionesDTO, HttpStatus.OK);
    }


}
