/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebamongo.prueba.controlador;

import com.pruebamongo.prueba.modelo.Curso;
import com.pruebamongo.prueba.servicio.CursoService;
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
public class CursoControlador {
    @Autowired
    CursoService curS;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarProductos() {
        return new ResponseEntity<>(curS.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Curso> crearProducto(
            @RequestBody Curso p) {
        return new ResponseEntity<>(curS.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizarProducto(@PathVariable Long id, @RequestBody Curso p) {
        Curso curN = curS.findById(id);
        if (curN == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                curN.setNombre(p.getNombre());
                curN.setDescripcion(p.getDescripcion());
                curN.setNivel(p.getNivel());
                curN.setProfesor(p.getProfesor());
                return new ResponseEntity<>(curS.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Curso> eliminarProducto(@PathVariable Long id) {
        curS.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}