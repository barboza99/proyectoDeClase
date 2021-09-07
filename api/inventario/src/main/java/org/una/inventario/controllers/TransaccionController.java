package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.TransaccionDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.services.ITransaccionService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacciones")
@Api(tags = {"Transacciones"})
public class TransaccionController {

    @Autowired
    private ITransaccionService transaccionService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ApiOperation(value = "Postea una transaccion", response = TransaccionDTO.class, tags = "Transacciones")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TransaccionDTO transaccionDTO) {
        Optional<TransaccionDTO> transaccionCreated = transaccionService.create(transaccionDTO);
        return new ResponseEntity<>(transaccionCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value =  "Obtiene una transaccion a partir de un id",
    response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id")Long id){
        Optional<TransaccionDTO> transaccionFound = transaccionService.findById(id);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de transacciones a partir del id del usuario y un rango de fecha",
    response = TransaccionDTO.class, responseContainer = "List", tags = "Transacciones")
    @GetMapping("/usuario/{id}/fechaDeCreacion/{startDate}/{endDate}")
    public ResponseEntity<?> findByUsuarioIdAndFechaCreacionBetween(@PathVariable(value = "id")Long id, @PathVariable(value = "startDate")Date startDate,
    @PathVariable(value = "endDate") Date endDate){
        Optional <List<TransaccionDTO>> result = transaccionService.findByUsuarioIdAndFechaCreacionBetween(id, startDate, endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de transaccioones a partir de un rango de la fecha de creacion", response = TransaccionDTO.class
            ,responseContainer = "List" ,  tags = "Transacciones")
    @GetMapping("/fechaDeCreacion/{dateStart}/{dateEnded}")
    public ResponseEntity<?> findByFechaCreacionBetween(@PathVariable(value = "dateStart")Date dateStart, @PathVariable(value = "dateEnded")Date dateEnded){
        Optional<List<TransaccionDTO>> result = transaccionService.findByFechaCreacionBetween(dateStart,  dateEnded);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

   /* @ApiOperation(value = "Obtiene una lista de transacciones a partir del id de Rol y un rango de fechas"
    , response = TransaccionDTO.class, responseContainer = "List", tags = "Transacciones")
    @GetMapping("/{id}/{startDate}/{endDate}")
    public ResponseEntity<?> findByRolIdAndFechaCreacionBetween(@PathVariable(value = "id")Long id,
                                                                @PathVariable(value = "startDate")Date startDate,
                                                                @PathVariable(value = "endDate")Date endDate){
        Optional<List<TransaccionDTO>> result = transaccionService.findByRolIdAndFechaCreacionBetween(id, startDate, endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }*/


    @ApiOperation(value = "Obtiene una lista de transacciones a partir del id del objeto y un rango de fechas"
    , response = TransaccionDTO.class, responseContainer = "List", tags = "Transacciones")
    @GetMapping("/{objetoId} /{startDate} /{endDate}")
    public ResponseEntity<?> findByObjetoAndFechaCreacionBetween (@PathVariable(value = "objetoId")String objetoId,
                          @PathVariable(value = "startDate")Date startDate,
                          @PathVariable(value = "endDate")Date endDate){
        Optional<List<TransaccionDTO>> result = transaccionService.findByObjetoAndFechaCreacionBetween(objetoId, startDate,endDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
