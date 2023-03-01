/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebamongo.prueba.modelo;

import java.util.List;
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
@Document(collection="Profesor")
@Data
public class Profesor {
    @Id
    private String prof_id;
    private String nombre;
    private String direccion;
    private String telefono;
    
    private Departamento departamento;
    private List<Departamento> listDepat;
    
}
