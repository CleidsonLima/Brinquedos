package com.brinquedos.cleidson.brinquedos.brinquedos.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


public class BrinquedoDTO {


        private Long id;
        @NotBlank(message = "O nome do brinquedo e obrigatorio!!!")
        private String nome;
        @NotBlank(message = "A cor do brinquedo e obrigatorio!!!")
        private String cor;

        private long caixaId;

}

