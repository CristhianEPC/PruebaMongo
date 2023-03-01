/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebamongo.prueba.modelo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author educr
 */
@Getter
@Setter
@Document(collection="Persona")
@Data
public class Curso {
    @Id
    private Long curs_id;
    private String nombre;
    private int nivel;
    private String descripcion;
    
    private Profesor profesor;
    
}
