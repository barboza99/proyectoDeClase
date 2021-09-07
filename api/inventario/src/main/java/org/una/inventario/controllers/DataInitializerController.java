package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.services.IDataInitializerService;

@RestController
@RequestMapping
@Api(tags = {"DataInitializer"})

public class DataInitializerController {

    @Autowired
    IDataInitializerService dataInitializerService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("createDatos/")
    @ApiOperation(value = "Crea los datos iniciales", tags = "DataInitializer")
    public ResponseEntity<?> initDevelopData() throws Exception{
        dataInitializerService.initDevelopData();
       return new ResponseEntity<>("OK", HttpStatus.CREATED) ;
    }

    @DeleteMapping()
    @ApiOperation(value = "Elimina toda la informacion", tags = "DataInitializer")
    public ResponseEntity<?> deleteAll() throws Exception{
        dataInitializerService.deleteAllData();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
