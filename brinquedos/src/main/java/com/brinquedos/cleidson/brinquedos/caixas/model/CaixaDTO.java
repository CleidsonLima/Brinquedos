package com.brinquedos.cleidson.brinquedos.caixas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


public class CaixaDTO {


    private Long id;
    @NotBlank(message = "O tamanho da caixa e obrigatorio!!!")
    private String tamanho;


}
