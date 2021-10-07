package org.una.inventario.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.AuthenticationRequest;
import org.una.inventario.dto.AuthenticationResponse;
import org.una.inventario.dto.RolDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.entities.Usuario;
import org.una.inventario.exceptions.InvalidCredentialsException;
import org.una.inventario.exceptions.PassWordIsBlankException;
import org.una.inventario.jwt.JwtProvider;
import org.una.inventario.repositories.IUsuarioRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.Optional;

@Service
public class AutenticacionServiceImplementation implements IAutenticacionService{

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        String token = jwtProvider.generateToken(authenticationRequest);
        Optional<Usuario> usuario = usuarioRepository.findByCedula(authenticationRequest.getCedula());

        if(usuario.isPresent() && bCryptPasswordEncoder.matches(authenticationRequest.getPassword(),
                usuario.get().getPasswordEncriptado() )){
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getCedula(), authenticationRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            authenticationResponse.setJwt(jwtProvider.generateToken(authenticationRequest));
            UsuarioDTO usuarioDTO = MapperUtils.DtoFromEntity(usuario.get(), UsuarioDTO.class);
            authenticationResponse.setUsuarioDTO(usuarioDTO);

            authenticationResponse.setRolDTO(RolDTO.builder().nombre(usuarioDTO.getRol().getNombre()).build());
            return  authenticationResponse;
        }else{
            throw new InvalidCredentialsException();
        }
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private String encriptarPassword(String password) {
        if (!password.isBlank()) {
            return bCryptPasswordEncoder.encode(password);
        }else{
            throw new PassWordIsBlankException();
        }
    }
}
