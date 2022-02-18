package com.apirestcrud.apirestcrud.services;

import java.util.ArrayList;
import java.util.Optional;

import com.apirestcrud.apirestcrud.models.UsuarioModel;
import com.apirestcrud.apirestcrud.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){ // se reciben todos los usuarios
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public ArrayList<String> obtenerCorreos(){
        ArrayList<UsuarioModel> usuarios= (ArrayList<UsuarioModel>)usuarioRepository.findAll();
        ArrayList<String> correos = new ArrayList();
        for (UsuarioModel nombre: usuarios) {
            correos.add(nombre.getEmail());
          }
          return correos;
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){ //se guarda un usuario que se recibe sin id
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad ){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
