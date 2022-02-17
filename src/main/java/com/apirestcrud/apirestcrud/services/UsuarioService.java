package com.apirestcrud.apirestcrud.services;

import java.util.ArrayList;

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

    public UsuarioModel gUsuario(UsuarioModel usuario){ //se guarda un usuario que se recibe sin id
        return usuarioRepository.save(usuario);
    }

}
