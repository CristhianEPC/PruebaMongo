/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebamongo.prueba.controlador;

import com.pruebamongo.prueba.modelo.Profesor;
import com.pruebamongo.prueba.servicio.ProfesorService;
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
public class ProfesorControlador {
    
    @Autowired
    ProfesorService proS;
    
    @GetMapping("/listarP")
    public ResponseEntity<List<Profesor>> listarProductos() {
        return new ResponseEntity<>(proS.findByAll(),
                HttpStatus.OK);
    }
    
    @PostMapping("/crearP")
    public ResponseEntity<Profesor> crearProducto(
            @RequestBody Profesor p) {
        return new ResponseEntity<>(proS.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizarProducto(@PathVariable Long id, @RequestBody Profesor p) {
        Profesor profesorN = proS.findById(id);
        if (profesorN == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                profesorN.setNombre(p.getNombre());
                profesorN.setTelefono(p.getTelefono());
                profesorN.setDireccion(p.getDireccion());
                return new ResponseEntity<>(proS.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarProducto(@PathVariable Long id) {
        proS.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
