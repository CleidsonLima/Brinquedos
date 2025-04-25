package com.brinquedos.cleidson.brinquedos.brinquedos.resources;


import com.brinquedos.cleidson.brinquedos.brinquedos.model.BrinquedoDTO;
import com.brinquedos.cleidson.brinquedos.brinquedos.services.BrinquedoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;

    @PostMapping()
    public ResponseEntity <BrinquedoDTO> create(@Valid @RequestBody BrinquedoDTO dto){
       BrinquedoDTO create = brinquedoService.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }
    @GetMapping()
    public ResponseEntity <List<BrinquedoDTO>> findAll(){
        return ResponseEntity.ok(brinquedoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BrinquedoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(brinquedoService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BrinquedoDTO> update(@PathVariable Long id, @Valid @RequestBody BrinquedoDTO dto) {
        return ResponseEntity.ok(brinquedoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        brinquedoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
