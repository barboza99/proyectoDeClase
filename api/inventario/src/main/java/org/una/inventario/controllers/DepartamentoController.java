package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.DepartamentoDTO;
import org.una.inventario.services.IDepartamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
@Api(tags = {"Departamentos"})

public class DepartamentoController {

    @Autowired
    private IDepartamentoService departamentoService;

    @ApiOperation(value = "Obtiene una lista de los departamentos según estado",  response = DepartamentoDTO.class, responseContainer = "List", tags = "Departamentos")
    @GetMapping("/findByEstado/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado")boolean estado){
        Optional<List<DepartamentoDTO>> departamentoFound = departamentoService.findByEstado(estado);
        return new ResponseEntity<>(departamentoFound, HttpStatus.OK);
    }

}
