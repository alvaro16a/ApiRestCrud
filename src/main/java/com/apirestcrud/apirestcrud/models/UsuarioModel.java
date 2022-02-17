package com.apirestcrud.apirestcrud.models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity// especificamos que es un modelo real 
@Table(name = "usuario") //especificamos el nombre de la tabla para que no sea el de la clase
public class UsuarioModel {

    @Id // se le notifica  a la tabla que la siguiente variable es un id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//los valores del id son generados automaticamente y se auto incrementan
    @Column(unique = true, nullable = false)// los id son unicos y no peden ser nulos
    private Long id;


    private String nombre;
    private String email;
    private Integer prioridad;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    
}
