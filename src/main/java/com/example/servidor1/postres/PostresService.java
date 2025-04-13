package com.example.servidor1.postres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PostresService {

     //Inyeccion de dependencias
    @Autowired
    private PostresRepository postresRepository;

    //Desarrollar los metodos el crud
    //Metodo para el insert 
    public Postres guardar(Postres entity)
    {
        return postresRepository.save(entity);
    }

    //Buscar por id
    public Postres getById(Long id)
    {
        return postresRepository.findById(id).orElse(null);
    }

    //Buscar todos los datos de la entidad
    public List<Postres> getAll()
    {
        return (List<Postres>) postresRepository.findAll();
    }

    //Metodo para borrar
    public void deleteById(Long id)
    {
        postresRepository.deleteById(id);
    }
    
}
