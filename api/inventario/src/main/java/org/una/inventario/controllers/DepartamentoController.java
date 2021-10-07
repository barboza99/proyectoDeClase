package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.DepartamentoDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.services.IDepartamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
@Api(tags = {"Departamentos"})

public class DepartamentoController {

    @Autowired
    private IDepartamentoService departamentoService;

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @ApiOperation(value = "Obtiene una lista de los departamentos según estado",  response = DepartamentoDTO.class, responseContainer = "List", tags = "Departamentos")
    @GetMapping("/findByEstado/{estado}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "estado")boolean estado){
        Optional<List<DepartamentoDTO>> departamentoFound = departamentoService.findByEstado(estado);
        return new ResponseEntity<>(departamentoFound, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Postea un departamento", response = DepartamentoDTO.class, tags = "Departamentos")
    @PostMapping("/")
        public ResponseEntity<?> create(@RequestBody DepartamentoDTO departamentoDTO){
        Optional<DepartamentoDTO> departamentoCreated= departamentoService.create(departamentoDTO);
        return new ResponseEntity<>(departamentoCreated, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    @ApiOperation(value = "Obtiene una lista de todos los Departamentos", response = DepartamentoDTO.class, responseContainer = "List", tags = "Departamentos")
    @GetMapping()
    public @ResponseBody ResponseEntity<?> findAll() {
        Optional<List<DepartamentoDTO>> result = departamentoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
