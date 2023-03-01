/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebamongo.prueba.servicio;

import com.pruebamongo.prueba.modelo.Curso;
import com.pruebamongo.prueba.repositorio.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author educr
 */
@Service
public class CorsoServiceImpl extends GenericServiceImpl<Curso, Long> implements CursoService{
    @Autowired
    CursoRepositorio curR;

    @Override
    public CrudRepository<Curso, Long> getDao() {
        return curR;
    }
    
}
