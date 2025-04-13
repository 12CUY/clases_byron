package com.example.servidor1.cocina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/cocina")
public class CocinaController {
    @Autowired
    private CocinaService cocinaService;

    //Obtener todos los datos
    @GetMapping("/")
    public List<Cocina> findAll()
    {
        return cocinaService.findAll();
    }

    //Obtener por id
    @GetMapping("/{id}")
    public Cocina findById(@PathVariable Long id)
    {
        return cocinaService.findById(id);
    }

    //Para guardar un registro
    @PostMapping("/")
    public Cocina save(@RequestBody Cocina entity)
    {
        return cocinaService.save(entity);
    }

    //Para actualizar parcialmente
    @PatchMapping("/{id}")
    public Cocina patchUpdate(@PathVariable Long id, @RequestBody Cocina updateEntity)
    {
        return cocinaService.patchCocina(id, updateEntity);
    }

    //Para actualizar todo
    @PutMapping("/{id}")
    public Cocina update(@PathVariable Long id, @RequestBody Cocina updateEntity)
    {   
        return cocinaService.save(updateEntity);
    }
}
