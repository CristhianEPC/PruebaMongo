/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pruebamongo.prueba.repositorio;

import com.pruebamongo.prueba.modelo.Profesor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author educr
 */
public interface ProfesorRepositorio extends MongoRepository<Profesor, Long>{
    
}
