package com.brinquedos.cleidson.brinquedos.brinquedos.resources;


import com.brinquedos.cleidson.brinquedos.brinquedos.model.Brinquedos;
import com.brinquedos.cleidson.brinquedos.brinquedos.services.BrinquedosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedosController {

    @Autowired
    private BrinquedosService service;

    @PostMapping("/{caixaId}")
    public Brinquedos create(@PathVariable Long caixaId, @RequestBody Brinquedos brinquedos){
        return service.insert(caixaId,brinquedos);
    }
    @GetMapping()
    public List<Brinquedos> findAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Brinquedos findById(@PathVariable Long id){
        return service.findById(id);
    }
    @PutMapping("/{id}")
    public Brinquedos update(@PathVariable Long id, @RequestBody Brinquedos brinquedos){
        return service.update(id, brinquedos);
    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        service.delete(id);
    }
}
