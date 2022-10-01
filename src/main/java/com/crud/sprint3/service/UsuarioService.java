package com.crud.sprint3.service;
import com.crud.sprint3.model.Usuario;
import com.crud.sprint3.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //funcion que busca al usuario
    public Usuario buscarPorEmail(String email) {
        return this.usuarioRepository.findByEmail(email);
    }


    //funcion que guarda a un nuevo usuario
    public Usuario crearUsuario(Usuario nuevoUsuario){
        return this.usuarioRepository.save(nuevoUsuario);
    }





    public Usuario getOrCreateUsuario(Map<String, Object> DatosUsuario) {

        String email = (String) DatosUsuario.get("email");
        Usuario usuario = buscarPorEmail(email);

        // validamos si el usuario existe o no

        if (usuario == null) {
            String alias = (String) DatosUsuario.get("nickname");
            String imagen = (String) DatosUsuario.get("picture");
            String auth0Id = (String) DatosUsuario.get("sub");

            Usuario nuevoUsuario = new Usuario(email = email, imagen = imagen, auth0Id = auth0Id);
            return crearUsuario(nuevoUsuario);
        }
       System.out.println(usuario.getEmail());
        return usuario;

    }













    /*
    //post
    public Usuario guardarUsuario(Usuario usuario){
        return UsuarioRepository.save(usuario);
    }

    //delete
    public void eliminarUsuario(Long id){
        UsuarioRepository.deleteById(id);
    }

    //get
    public List<Usuario> verUsuarios() {
        return UsuarioRepository.findAll();
    }

    //get por id
    public Usuario obtenerUsuarioPorId(Long id) {
        return UsuarioRepository.findById(id).get();
    }
*/

}
