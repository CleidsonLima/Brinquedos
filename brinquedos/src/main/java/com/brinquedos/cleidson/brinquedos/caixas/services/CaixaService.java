package com.brinquedos.cleidson.brinquedos.caixas.services;

import com.brinquedos.cleidson.brinquedos.caixas.model.Caixa;
import com.brinquedos.cleidson.brinquedos.caixas.model.CaixaDTO;
import com.brinquedos.cleidson.brinquedos.caixas.repositories.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaixaService {

    @Autowired
    private CaixaRepository caixaRepository;

    public CaixaDTO insert(CaixaDTO dto){
        Caixa caixa = new Caixa();
        caixa.setTamanho(dto.getTamanho()); // ID é gerado automaticamente
        Caixa save = caixaRepository.save(caixa);
        return new CaixaDTO(save.getId(), save.getTamanho()); // Corrigido aqui
    }


    public List<CaixaDTO> findAll(){
        return caixaRepository.findAll().stream()
                .map(c -> new CaixaDTO(c.getId(), c.getTamanho()))
                .collect(Collectors.toList());
    }

    public CaixaDTO findById( Long id){
        Caixa caixa = caixaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Caixa nao encontrada"));

        return new CaixaDTO(caixa.getId(), caixa.getTamanho());
    }

    public CaixaDTO update( Long id,  CaixaDTO dto){
       Caixa caixa = caixaRepository
               .findById(id).orElseThrow(()-> new RuntimeException("Caixa não encontrada"));
       caixa.setTamanho(dto.getTamanho());
       Caixa save = caixaRepository.save(caixa);

       return new CaixaDTO(save.getId(), save.getTamanho());
    }

    public void delete(Long id){
        caixaRepository.deleteById(id);
    }
}
