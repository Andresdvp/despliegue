package com.crud.sprint3.repositories;

import com.crud.sprint3.model.Empleado;
import com.crud.sprint3.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    //recibe la clase y el tipo de dato del id a la cual pertenece

}




