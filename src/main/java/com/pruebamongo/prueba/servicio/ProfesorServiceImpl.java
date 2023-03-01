/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebamongo.prueba.servicio;

import com.pruebamongo.prueba.modelo.Profesor;
import com.pruebamongo.prueba.repositorio.ProfesorRepositorio;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author educr
 */
@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor, Long> implements ProfesorService{
@Autowired
ProfesorRepositorio proRe;
    @Override
    public CrudRepository<Profesor, Long> getDao() {
        return proRe;
    }
    
}
