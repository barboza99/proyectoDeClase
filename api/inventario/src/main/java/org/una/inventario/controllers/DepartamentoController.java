package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.una.inventario.services.IDepartamentoService;

@RestController
@RequestMapping("/departamentos")
@Api(tags = {"Usuarios"})
public class DepartamentoController {

    //@Autowired
    private IDepartamentoService departamentoService;


}
