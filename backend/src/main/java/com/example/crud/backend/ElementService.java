package com.example.crud.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElementService {
    @Autowired
    private ElementRepository elementRepository;

    // GET all elements on DB
    public Iterable<Element> listAll(){
        return elementRepository.findAll();
    }

    // POST save element on DB 
    public Element save(Element element){
        return elementRepository.save(element);
    }


    // DELETE current element with same id
    public void delete(Long id){
        elementRepository.deleteById(id);    
    }


    // GET current element with same id on DB
    public Element getById(Long id){
        return elementRepository.findById(id).
            orElseThrow(); 
    }
}
