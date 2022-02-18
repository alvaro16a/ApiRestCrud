package com.apirestcrud.apirestcrud.repositories;

import java.util.ArrayList;

import com.apirestcrud.apirestcrud.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> { //tipo de usuario y tipo de dato del id
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
