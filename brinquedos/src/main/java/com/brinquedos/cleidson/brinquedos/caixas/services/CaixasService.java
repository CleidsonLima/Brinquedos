package com.brinquedos.cleidson.brinquedos.caixas.services;

import com.brinquedos.cleidson.brinquedos.caixas.model.Caixas;
import com.brinquedos.cleidson.brinquedos.caixas.repositories.CaixasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CaixasService {

    @Autowired
    private CaixasRepository caixasRepository;

    public Caixas insert(Caixas caixas){
        return caixasRepository.save(caixas);
    }

    public List<Caixas> findAll(){
        return caixasRepository.findAll();
    }

    public Caixas findById(@PathVariable Long id){
        return caixasRepository.findById(id).orElseThrow(()-> new RuntimeException("Caixa não encontrada"));
    }

    public Caixas update(@PathVariable Long id, @RequestBody Caixas novasCaixas){
       Caixas caixas = caixasRepository.findById(id).orElseThrow(()-> new RuntimeException("Caixa não encontrada"));

       novasCaixas.setTamanho(caixas.getTamanho());

       return caixasRepository.save(caixas);
    }

    public void delete(@PathVariable Long id){
        caixasRepository.deleteById(id);
    }
}
