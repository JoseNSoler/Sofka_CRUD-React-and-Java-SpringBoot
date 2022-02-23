package com.example.crud.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElementController {
    
    @Autowired
    private ElementService elementService;

    // GET all elements on DB
    @GetMapping(value = "api/list")
    public Iterable<Element> list(){
        return elementService.listAll();
    }

    // POST save element on DB
    @PostMapping(value = "api/list")
    public Element save(@RequestBody Element element){
        return elementService.save(element);
    }

    // PUT current element or save it
    @PutMapping(value = "api/list")
    public Element update(@RequestBody Element element){
        if(element.getId() != null) return elementService.save(element);
        throw new RuntimeException("No existe un id relacionado a una tarea en la lista");
    }


    // DELETE current element with same id
    @DeleteMapping(value = "api/{id}/list")
    public void delete(@PathVariable("id") Long id){
        elementService.delete(id);    
    }


    // GET current element with same id on DB
    @GetMapping(value = "api/{id}/list")
    public Element getById(@PathVariable("id") Long id){
        return elementService.getById(id);
    }
}
