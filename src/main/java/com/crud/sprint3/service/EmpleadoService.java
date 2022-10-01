package com.crud.sprint3.service;

import com.crud.sprint3.model.Empleado;
import com.crud.sprint3.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Indica que es un servicio
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Empleado> verEmpleados(){
        return empleadoRepository.findAll();
    } //llama al metodo findAll del repositorio para traer todos los empleados

    public void crearEmpleado(Empleado empleado){
        empleadoRepository.save(empleado); //guarda el empleado en la base de datos, save metodo que viene de JpaRepository
    }



    public Empleado actualizarEmpleado(Long id, Empleado empleado){
        Empleado empleadoActual = empleadoRepository.findById(id).orElseThrow();
        empleadoActual.setNombre(empleado.getNombre());
        empleadoActual.setApellido(empleado.getApellido());
        empleadoActual.setEmail(empleado.getEmail());
        empleadoActual.setTelefono(empleado.getTelefono());
        return this.empleadoRepository.save(empleadoActual);

    }

    //eliminarEmpleado por id
    public Empleado eliminarEmpleado(Long id){
        Empleado empleadoactual= empleadoRepository.findById(id).orElseThrow();
        this.empleadoRepository.deleteById(id);

        return empleadoactual;
    }

    //obtenerEmpleado por id
    public Empleado obtenerEmpleadoPorId(Long id){
        return empleadoRepository.findById(id).orElseThrow();
    }

}










