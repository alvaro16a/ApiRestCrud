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

    public ArrayList<UsuarioModel> obtenerUsuarios() { // se reciben todos los usuarios
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public ArrayList<String> hacerReporte() { // se hace un reporte sobre los usuariso en la base de dato
        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        int numeroUsuarios = usuarios.size();
        double usuarioPrioridad[] = new double[6];
        ArrayList<String> reporte = new ArrayList();
        for (UsuarioModel persona : usuarios) {
            switch (persona.getPrioridad()) {
                case 1:
                    usuarioPrioridad[0]++;
                    break;
                case 2:
                    usuarioPrioridad[1]++;
                    break;
                case 3:
                    usuarioPrioridad[2]++;
                    break;
                case 4:
                    usuarioPrioridad[3]++;
                    break;
                case 5:
                    usuarioPrioridad[4]++;
                    break;
                default:
                    usuarioPrioridad[5]++;
            }

        }
        reporte.add("Numero total de usuarios:" + numeroUsuarios);
        reporte.add("Porcentaje de usuarios de Prioridad 1 = " + (usuarioPrioridad[0]*100/numeroUsuarios)+"%");
        reporte.add("Porcentaje de usuarios de Prioridad 2 = " + (usuarioPrioridad[1]*100/numeroUsuarios)+"%");
        reporte.add("Porcentaje de usuarios de Prioridad 3 = " + (usuarioPrioridad[2]*100/numeroUsuarios)+"%");
        reporte.add("Porcentaje de usuarios de Prioridad 4 = " + (usuarioPrioridad[3]*100/numeroUsuarios)+"%");
        reporte.add("Porcentaje de usuarios de Prioridad 5 = " + (usuarioPrioridad[4]*100/numeroUsuarios)+"%");
        reporte.add("Porcentaje de usuarios de Prioridades especiales = " + (usuarioPrioridad[5]*100/numeroUsuarios) +"%");
        
        return reporte;
    }

    public ArrayList<String> obtenerCorreos() {
        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        ArrayList<String> correos = new ArrayList();
        for (UsuarioModel nombre : usuarios) {
            correos.add(nombre.getEmail());
        }
        return correos;
    }

    public ArrayList<String> obtenerCorreosPorPrioridad(Integer prioridad) {
        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepository.findByPrioridad(prioridad);
        ArrayList<String> correos = new ArrayList();
        for (UsuarioModel nombre : usuarios) {
            correos.add(nombre.getEmail());
        }
        return correos;
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) { // se guarda un usuario que se recibe sin id
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
