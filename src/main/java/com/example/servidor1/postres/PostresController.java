package com.example.servidor1.postres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/postres")
//Decoradores propios de SW
@Tag(name="Postres", description = "Entidad que mapea la tabla Alumnos")
public class PostresController {
    //Inyeccion de dependencias
    @Autowired
    private PostresService alumnoService;
    //Metodo post
    @PostMapping("/")
    @Operation(summary = "Permite insertar una entidad de tipo Alumno", 
    description = "Inserta un JSON con los datos de Alumno")
    public Postres guardar(@RequestBody Postres entity)
    {
        return alumnoService.guardar(entity);
    }    

    //Metodo para buscar por id
    @GetMapping("/{id}")
    public Postres getById(@PathVariable Long id)
    {
        return alumnoService.getById(id);
    }
    
    //Metodo para obtener todos los datos
    @GetMapping("/")
    public List<Postres> getAll()
    {
        return alumnoService.getAll();
    }    

    //Borrar por id
    //Metodo para buscar por id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
         alumnoService.deleteById(id);
    }

    
}
