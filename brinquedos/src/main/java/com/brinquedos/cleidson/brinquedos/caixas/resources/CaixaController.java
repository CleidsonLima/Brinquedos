package com.brinquedos.cleidson.brinquedos.caixas.resources;

import com.brinquedos.cleidson.brinquedos.caixas.model.Caixa;
import com.brinquedos.cleidson.brinquedos.caixas.model.CaixaDTO;
import com.brinquedos.cleidson.brinquedos.caixas.services.CaixaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caixas")
public class CaixaController {

    @Autowired
    private CaixaService caixaService;


    @PostMapping
    public ResponseEntity<CaixaDTO> create(@Valid @RequestBody CaixaDTO dto){
        CaixaDTO criada = caixaService.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }
    @GetMapping
    public ResponseEntity<List<CaixaDTO>> findAll(){
        return ResponseEntity.ok(caixaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CaixaDTO> findById(@PathVariable Long id){
        return  ResponseEntity.ok(caixaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaixaDTO> update(@PathVariable Long id, @RequestBody CaixaDTO dto){
        return ResponseEntity.ok(caixaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        caixaService.delete(id);
        return  ResponseEntity.noContent().build();
    }


}
