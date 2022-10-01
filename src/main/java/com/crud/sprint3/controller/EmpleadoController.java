package com.crud.sprint3.controller;


import com.crud.sprint3.model.Empleado;
import com.crud.sprint3.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @PostMapping(path = "/empleado") //cuando se haga una peticion post a la ruta /crearEmpleado se ejecuta el metodo
    public RedirectView crearEmpleado(@ModelAttribute Empleado empleado, Model model){
        //requestbody para que se pueda mapear el json que se envia
        model.addAttribute((empleado));
        empleadoService.crearEmpleado(empleado); //llama al metodo crearEmpleado del servicio y le pasa el empleado que se recibe por parametro para crear el empleado
        return  new RedirectView("/empleado");
    }




/*
    @GetMapping(path = "/empleado")
    private List<Empleado> verEmpleados(){
        return empleadoService.verEmpleados();
    }

    //eliminarEmpleado por id deletemapping
    @DeleteMapping(path = "/empleado/{id}")
    private void eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.eliminarEmpleado(id);
    }



    @GetMapping(path = "/empleado/{id}")
    private Empleado obtenerEmpleadoPorId(@PathVariable("id") Long id){
        return empleadoService.obtenerEmpleadoPorId(id);
    }
*/

    @PutMapping(path = "/empleado/{id}")//metodo put para actualizar empleado
    private RedirectView actualizarEmpleado(@PathVariable Long id, Empleado empleado){
        empleadoService.actualizarEmpleado(id,empleado); //llama al metodo crearEmpleado del servicio y le pasa el empleado que se recibe por parametro para crear el empleado
        return new RedirectView("/empleado");
    }


    //eliminarEmpleado por id deletemapping
    @DeleteMapping(path = "/empleado/{id}")
    private RedirectView eliminarEmpleado(@PathVariable("id") Long id){
        this.empleadoService.eliminarEmpleado(id);
    return new RedirectView("/empleado");
    }

}
