package com.brinquedos.cleidson.brinquedos.caixas.resources;

import com.brinquedos.cleidson.brinquedos.caixas.model.Caixas;
import com.brinquedos.cleidson.brinquedos.caixas.services.CaixasService;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caixas")
public class CaixasController {

    @Autowired
    private CaixasService caixasService;


    @PostMapping
    public Caixas create(@RequestBody Caixas caixas){
        return caixasService.insert(caixas);
    }
    @GetMapping
    public List<Caixas> findAll(){
        return caixasService.findAll();
    }
    @GetMapping("/{id}")
    public Caixas findById(@PathVariable Long id){
        return  caixasService.findById(id);
    }

    @PutMapping("/{id}")
    public Caixas update(@PathVariable Long id, @RequestBody Caixas caixas){
        return caixasService.update(id, caixas);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        caixasService.delete(id);
    }


}
