package com.brinquedos.cleidson.brinquedos.brinquedos.services;

import com.brinquedos.cleidson.brinquedos.brinquedos.model.Brinquedos;
import com.brinquedos.cleidson.brinquedos.brinquedos.repositories.BrinquedosRepository;
import com.brinquedos.cleidson.brinquedos.caixas.model.Caixas;
import com.brinquedos.cleidson.brinquedos.caixas.repositories.CaixasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BrinquedosService {


    @Autowired
    private BrinquedosRepository brinquedosRepository;

    @Autowired
    private CaixasRepository caixasRepository;


    public Brinquedos insert(Long caixaId, Brinquedos brinquedos){
        Caixas caixa = caixasRepository.findById(caixaId).orElseThrow(()-> new RuntimeException("Caixa não encontrada"));

        brinquedos.setCaixa(caixa);
        return brinquedosRepository.save(brinquedos);
    }


    public List<Brinquedos> findAll(){
        return brinquedosRepository.findAll();
    }


    public Brinquedos findById (@PathVariable Long id){
        return brinquedosRepository.findById(id).orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));
    }


    public Brinquedos update(@PathVariable Long id, @RequestBody Brinquedos novoBrinquedo){
       Brinquedos brinquedos = brinquedosRepository.findById(id).orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));

        brinquedos.setNome(novoBrinquedo.getNome());
        brinquedos.setCor(novoBrinquedo.getCor());

        if (novoBrinquedo.getCaixa() != null && novoBrinquedo.getCaixa().getId() != null) {
            Caixas novaCaixa = caixasRepository.findById(novoBrinquedo.getCaixa().getId())
                    .orElseThrow(() -> new RuntimeException("Nova caixa não encontrada"));
            brinquedos.setCaixa(novaCaixa);
        }

        return brinquedosRepository.save(brinquedos);
    }


    public void delete(Long id){
        brinquedosRepository.deleteById(id);
    }
}
