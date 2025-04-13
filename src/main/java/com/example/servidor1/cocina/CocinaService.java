package com.example.servidor1.cocina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocinaService {

    @Autowired
    private CocinaRepository cocinaRepository;

    //Metodo para seleccionar todos
    public List<Cocina> findAll()
    {
        return (List<Cocina>) cocinaRepository.findAll();
    }

    //Buscar por id
    public Cocina findById(Long id)
    {
        return cocinaRepository.findById(id).orElse(null);
    }

    //Metodo para guardar
    public Cocina save(Cocina entity)
    {
        return cocinaRepository.save(entity);
    }

    //Metodo patch
    public Cocina patchCocina(Long id, Cocina entityUpdate)
    {
        //Forma
        //Cocina cocinaActualizar=cocinaRepository.findById(id).orElse(null);
        
        //Forma 2
        Cocina cocinaActualizar=cocinaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Id de cocina no encontrado"));

        //Revisar cada atrubuto si es ! de null
        //Para address
        if (entityUpdate.getAddress()!=null)
        {
            cocinaActualizar.setAddress(entityUpdate.getAddress());
        }

        //Para description
        if(entityUpdate.getDescription()!=null)
        {
            cocinaActualizar.setDescription(entityUpdate.getDescription());
        }
        //Para Alumno
        if(entityUpdate.getPostres()!=null)
        {
            cocinaActualizar.setPostres(entityUpdate.getPostres());
        }

        //Retornar el objeto
        return cocinaRepository.save(cocinaActualizar);
    }
    
}
