package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.RolDTO;
import org.una.inventario.services.IRolService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@Api(tags = {"Roles"})

public class RolController {

    @Autowired
    private IRolService rolService;

    @ApiOperation(value = "Obtiene un rol a partir de ud id", response = RolDTO.class, tags = "Roles")
    @GetMapping("/{id}")
    ResponseEntity <?> findById(@PathVariable(value = "id")Long id){
        Optional<RolDTO> rolFound = rolService.findById(id);
        return new ResponseEntity<>(rolFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de todos los roles", response =  RolDTO.class, responseContainer = "List", tags = "Roles")
    @GetMapping()
    ResponseEntity<?> findAll(){
        Optional<List<RolDTO>> rolDTOList = rolService.findAll();
        return new ResponseEntity<>(rolDTOList, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ApiOperation(value = "Postea un rol", response = RolDTO.class, tags = "Roles")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody RolDTO rolDTO) {
        Optional<RolDTO> rolCreated = rolService.create(rolDTO);
        return new ResponseEntity<>(rolCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Postea un rol a partir de su id", response = RolDTO.class, tags = "Roles")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id")Long id, @RequestBody RolDTO rolModified){
        Optional<RolDTO> rolUpdate = rolService.update(rolModified, id);
        return new ResponseEntity<>(rolUpdate, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un rol a partir de un rango de la fecha de creacion", response = RolDTO.class
    ,responseContainer = "List" ,  tags = "Roles")
    @GetMapping("/fechas/{dateStart}/{dateEnded}")
    public ResponseEntity<?> findByFechaCreacionBetween(@PathVariable(value = "dateStart")Date dateStart, @PathVariable(value = "dateEnded")Date dateEnded){
        Optional<List<RolDTO>> result = rolService.findByFechaCreacionBetween(dateStart,  dateEnded);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Elimina un rol por su id", response = RolDTO.class, tags = "Roles")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id")Long id) throws Exception{
        rolService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping()
    @ApiOperation(value = "Elimina todos los roles", response = RolDTO.class, tags = "Roles")
    public ResponseEntity<?> deleteAll() throws Exception{
        rolService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
