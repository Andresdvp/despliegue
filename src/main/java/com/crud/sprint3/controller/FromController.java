package com.crud.sprint3.controller;

import com.crud.sprint3.model.Empleado;
import com.crud.sprint3.model.Usuario;
import com.crud.sprint3.service.EmpleadoService;
import com.crud.sprint3.service.UsuarioService;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FromController {
    EmpleadoService empleadoService;
    //servicios de usuarios
    UsuarioService usuarioService;

    public FromController(EmpleadoService empleadoService,UsuarioService usuarioService) {
        this.empleadoService = empleadoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")// ruta raiz
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal !=null) {
            Usuario usuario = this.usuarioService.getOrCreateUsuario(principal.getClaims());
            model.addAttribute("usuario", usuario);

        }
        return "index";
    }
/*
@GetMapping("/")// ruta raiz
    public String index(){
        return "index";
    }
 */

    @GetMapping("/empleado")//mapear empleados
    public String empleado(Model modelE){
        List<Empleado> empleado=this.empleadoService.verEmpleados();
        modelE.addAttribute("empleado",empleado);
        return "empleado";
    }

@GetMapping("/empleado/nuevo")// mapear nuevos empleados
    public String nuevoEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        return "nuevo-empleado";
}

    @GetMapping("/empleado/{id}")//actualizar empleado
    public String actualizarempleado(@PathVariable long id, Model model) {
        Empleado empleadoFind= this.empleadoService.obtenerEmpleadoPorId(id);
        model.addAttribute("empleadoFind",empleadoFind);
        return "actualizar-empleado";
    }





}
