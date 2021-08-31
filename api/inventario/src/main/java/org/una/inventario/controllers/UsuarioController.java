package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.services.IUsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@Api(tags = {"Usuarios"})

public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = UsuarioDTO.class, tags = "Seguridad")
    @PutMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@PathVariable(value = "cedula") String cedula, @PathVariable(value = "password") String password) {
        Optional<UsuarioDTO> usuarioFound = usuarioService.login(cedula, password);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtiene una lista de todos los Usuarios", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    @GetMapping()
    public @ResponseBody ResponseEntity<?> findAll() {
        Optional<List<UsuarioDTO>> result = usuarioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ApiOperation(value = "Obtiene un usuario a partir de su id", response = UsuarioDTO.class, tags = "Usuarios")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<UsuarioDTO> usuarioFound = usuarioService.findById(id);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una lista de usuarios a partir del id de departamento", response = UsuarioDTO.class
    , responseContainer = "List", tags = "Usuarios")
    @GetMapping("/departamento/{id}")
    public ResponseEntity<?> findByDepartamentoId(@PathVariable(value = "id") Long id) {
        Optional<List<UsuarioDTO>> listUsuariosFound = usuarioService.findByDepartamentoId(id);
        return new ResponseEntity<>(listUsuariosFound, HttpStatus.OK);
    }

    @GetMapping("/cedula/{term}")
    @ApiOperation(value = "Obtiene una lista de Usuarios aproximados a un numero de cedula",
    response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByCedulaAproximate(@PathVariable(value = "term") String term) {
            Optional<List<UsuarioDTO>> result = usuarioService.findByCedulaAproximate(term);
            return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/nombre/{term}")
    @ApiOperation(value = "Obtiene una lista de Usuarios aproximados al nombre completo", response = UsuarioDTO.class,
    responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByNombreCompletoAproximateIgnoreCase(@PathVariable(value = "term") String term) {
            Optional<List<UsuarioDTO>> result = usuarioService.findByNombreCompletoAproximateIgnoreCase(term);
            return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ApiOperation(value = "Postea un usuario", response = UsuarioDTO.class, tags = "Usuarios")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody UsuarioDTO usuarioDTO) {
            Optional<UsuarioDTO> usuarioCreated = usuarioService.create(usuarioDTO);
            return new ResponseEntity<>(usuarioCreated, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Postea un usuario con el id", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody UsuarioDTO usuarioModified) {

            Optional<UsuarioDTO> usuarioUpdated = usuarioService.update(usuarioModified, id);
            return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Elimina un usuario mediante el id", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
            usuarioService.delete(id);
            return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Elimina todos los usuarios", response = UsuarioDTO.class, tags = "Usuarios")
    public ResponseEntity<?> deleteAll() throws Exception {
            usuarioService.deleteAll();
            return new ResponseEntity<>("Ok" , HttpStatus.OK);
    }

}
