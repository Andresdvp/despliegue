package com.crud.sprint3.controller;

import com.crud.sprint3.model.Usuario;
import com.crud.sprint3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UsuarioController {

/*
    @Autowired
    UsuarioService usuarioService;

    @PostMapping(path = "/perfil")
    private void guardarPerfil(@RequestBody Usuario perfil){
        usuarioService.guardarUsuario(perfil);
    }

    @GetMapping(path = "/perfil")
    private List<Usuario> obtenerPerfiles(){
        return usuarioService.verUsuarios();

    }
    @GetMapping(path = "/perfil/{id}")
    private Usuario obtenerPerfilPorId(@PathVariable("id") Long id){
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @DeleteMapping(path = "/perfil/{id}")
    private void eliminarPerfil(@PathVariable("id") Long id){
        usuarioService.eliminarUsuario(id);
    }

    @PutMapping(path = "/perfil/{id}")
    private void actualizarPerfil(@RequestBody Usuario perfil){
        usuarioService.guardarUsuario(perfil);
    }
 */


}
