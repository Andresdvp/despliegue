package com.crud.sprint3.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.sprint3.model.Usuario;
public interface UsuarioRepository extends  JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);



}

