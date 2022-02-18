package com.apirestcrud.apirestcrud.controllers;

import com.apirestcrud.apirestcrud.services.UsuarioService;

import java.util.ArrayList;
import java.util.Optional;

import com.apirestcrud.apirestcrud.models.UsuarioModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController //Le indica a spring que es la funcion a ejecutar
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired //instancia la clase UsuarioService automaticamente
    UsuarioService usuarioService;

    @GetMapping()//devuelve una lista con todos los usuarios
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping(value = "/correos")//devuelve un Lista con todos los correos de los usuarios
    public ArrayList<String> obtenerCorreos(){
        return this.usuarioService.obtenerCorreos();
    }

    @GetMapping(value = "/reporte")//devuelve un reporte con informacion de los usuarios
    public ArrayList<String> hacerReporte(){
        return this.usuarioService.hacerReporte();
    }

    @GetMapping(value = "/correos/{prioridad}")//devuelve un Lista con todos los correos de los usuarios deacuerdo a su priodidad
    public ArrayList<String> obtenerCorreosPorPrioridad(@PathVariable("prioridad") Integer prioridad){
        return this.usuarioService.obtenerCorreosPorPrioridad(prioridad);
    }


    @PostMapping() //guarda un nuevo usuario o carga la informacion de alguno existente por el id
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")//encuentra un usuario por su id
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping(path = "/query")//optiene los usuarios que tienen determinada prioridad
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}" )//al recibir una solicitud delete elimina el usuario con una determinada id
    public String eliminarPorID(@PathVariable("id") Long id){
        boolean ok=this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario usando el id" + id;
        }else{
            return "No se elimino el usuario con id" +id;
        }
    }
}
