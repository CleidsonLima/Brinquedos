package com.brinquedos.cleidson.brinquedos.brinquedos.services;

import com.brinquedos.cleidson.brinquedos.brinquedos.model.BrinquedoDTO;
import com.brinquedos.cleidson.brinquedos.brinquedos.model.Brinquedos;
import com.brinquedos.cleidson.brinquedos.brinquedos.repositories.BrinquedoRepository;
import com.brinquedos.cleidson.brinquedos.caixas.model.Caixa;
import com.brinquedos.cleidson.brinquedos.caixas.repositories.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrinquedoService {


    @Autowired
    private BrinquedoRepository brinquedoRepository;

    @Autowired
    private CaixaRepository caixaRepository;


    public BrinquedoDTO insert(BrinquedoDTO dto){
        Caixa caixa = caixaRepository.findById(dto.getCaixaId()).orElseThrow(()-> new RuntimeException("Caixa não encontrada"));

        Brinquedos brinquedos = new Brinquedos();

        brinquedos.setNome(dto.getNome());
        brinquedos.setCor(dto.getCor());
        brinquedos.setCaixa(caixa);

        Brinquedos salvo = brinquedoRepository.save(brinquedos);

        return new BrinquedoDTO(salvo.getId(), salvo.getNome(), salvo.getCor(), caixa.getId());

    }


    public List<BrinquedoDTO> findAll(){
        return brinquedoRepository.findAll()
                .stream()
                .map(b -> new BrinquedoDTO(b.getId(),b.getNome(),b.getCor(),b.getCaixa().getId()))
                .collect(Collectors.toList());
    }


    public BrinquedoDTO findById (Long id){
        Brinquedos b = brinquedoRepository.findById(id).orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));
     return new BrinquedoDTO(b.getId(), b.getNome(), b.getCor(), b.getCaixa().getId());
    }


    public BrinquedoDTO update(Long id, BrinquedoDTO dto){
       Brinquedos brinquedos = brinquedoRepository.findById(id).orElseThrow(() -> new RuntimeException("Brinquedo não encontrado"));
        Caixa caixa = caixaRepository.findById(dto.getCaixaId())
                .orElseThrow(() -> new RuntimeException("Nova caixa não encontrada"));

        brinquedos.setNome(dto.getNome());
        brinquedos.setCor(dto.getCor());
        brinquedos.setCaixa(caixa);

        Brinquedos save = brinquedoRepository.save(brinquedos);

        return new BrinquedoDTO(save.getId(), save.getNome(), save.getCor(), save.getCaixa().getId());
    }


    public void delete(Long id){
        brinquedoRepository.deleteById(id);
    }
}
