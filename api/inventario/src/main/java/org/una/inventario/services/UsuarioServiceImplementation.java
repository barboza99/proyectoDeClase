package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.AuthenticationRequest;
import org.una.inventario.dto.AuthenticationResponse;
import org.una.inventario.dto.RolDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.entities.Rol;
import org.una.inventario.entities.Usuario;
import org.una.inventario.exceptions.InvalidCredentialsException;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.exceptions.PassWordIsBlankException;
import org.una.inventario.jwt.JwtProvider;
import org.una.inventario.repositories.IUsuarioRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplementation implements IUsuarioService, UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto) {
        List<Usuario> usuarioList = usuarioRepository.findByNombreCompletoContainingIgnoreCase(nombreCompleto);
        List<UsuarioDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioList, UsuarioDTO.class);
        return Optional.ofNullable(usuarioDTOList);
    }

    private UsuarioDTO getSavedUsuarioDTO(UsuarioDTO usuarioDTO) {
        usuarioDTO.setPasswordEncriptado(encriptarPassword(usuarioDTO.getPasswordEncriptado()));
        Usuario usuario = MapperUtils.EntityFromDto(usuarioDTO, Usuario.class);
        Usuario usuarioCreated = usuarioRepository.save(usuario);
        return MapperUtils.DtoFromEntity(usuarioCreated, UsuarioDTO.class);
    }

    @Override
    @Transactional
    public Optional<UsuarioDTO> create(UsuarioDTO usuarioDTO) {
        return Optional.ofNullable(getSavedUsuarioDTO(usuarioDTO));
    }

    @Override
    @Transactional
    public Optional<UsuarioDTO> update(UsuarioDTO usuarioDTO, Long id) {
        if (usuarioRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedUsuarioDTO(usuarioDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        usuarioRepository.deleteAll();
    }

    /*@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    @Transactional(readOnly = true)
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
    }*/


    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) throw new NotFoundInformationException();
        UsuarioDTO usuarioDTO = MapperUtils.DtoFromEntity(usuario.get(), UsuarioDTO.class);
        return Optional.ofNullable(usuarioDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findJefeByDepartamento(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findJefeByDepartamento(id);
        if(usuario.isEmpty()) throw new NotFoundInformationException();
        UsuarioDTO usuarioDTO = MapperUtils.DtoFromEntity(usuario.get(), UsuarioDTO.class);
        return Optional.ofNullable(usuarioDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findNombreCompletoWithLikeSQL(String nombreCompleto) {
        Usuario usuario = usuarioRepository.findNombreCompletoWithLikeSQL(nombreCompleto);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(usuario, UsuarioDTO.class));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioRepository.findAll(), UsuarioDTO.class);
        return Optional.ofNullable(usuarioDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findByCedulaAproximate(String cedula) {
        List<Usuario> usuarioList = usuarioRepository.findByCedulaContaining(cedula);
        if(usuarioList.isEmpty()) return Optional.empty();
        List<UsuarioDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioList, UsuarioDTO.class);
        return Optional.ofNullable(usuarioDTOList);
    }

    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findByDepartamentoId(Long id) {
        List<Usuario> usuarioList = usuarioRepository.findByDepartamentoId(id);
        if (usuarioList.isEmpty()) throw new NotFoundInformationException();
        List<UsuarioDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioList, UsuarioDTO.class);
        return Optional.ofNullable(usuarioDTOList);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findByCedula(username);
        if (usuarioBuscado.isPresent()) {
            Usuario usuario = usuarioBuscado.get();
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
            return new User(usuario.getCedula(), usuario.getPasswordEncriptado(), roles);
        } else {
            throw new UsernameNotFoundException("Username not found, check your request");
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
    } // TODO: Piense donde se debe llamar esta funci??n

}

