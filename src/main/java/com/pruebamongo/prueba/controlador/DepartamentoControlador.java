/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebamongo.prueba.controlador;

import com.pruebamongo.prueba.modelo.Departamento;
import com.pruebamongo.prueba.servicio.DepartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author educr
 */
@RestController
@RequestMapping("/api")
public class DepartamentoControlador {
    @Autowired
    DepartService dep;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Departamento>> listarProductos() {
        return new ResponseEntity<>(dep.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Departamento> crearProducto(
            @RequestBody Departamento p) {
        return new ResponseEntity<>(dep.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Departamento> actualizarProducto(@PathVariable Long id, @RequestBody Departamento p) {
        Departamento departaN = dep.findById(id);
        if (departaN == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                departaN.setNombre(p.getNombre());
                departaN.setDescripcion(p.getDescripcion());
                departaN.setDirector(p.getDirector());
                return new ResponseEntity<>(dep.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Departamento> eliminarProducto(@PathVariable Long id) {
        dep.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
