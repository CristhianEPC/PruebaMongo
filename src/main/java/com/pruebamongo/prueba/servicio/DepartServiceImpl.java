/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebamongo.prueba.servicio;

import com.pruebamongo.prueba.modelo.Departamento;
import com.pruebamongo.prueba.repositorio.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author educr
 */
public class DepartServiceImpl extends GenericServiceImpl<Departamento, Long> implements DepartService{

    @Autowired
    DepartamentoRepositorio depR;
    
    @Override
    public CrudRepository<Departamento, Long> getDao() {
        return depR;
    }
    
}
