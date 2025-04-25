package com.brinquedos.cleidson.brinquedos.brinquedos.model;

import com.brinquedos.cleidson.brinquedos.caixas.model.Caixa;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Brinquedos {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @EqualsAndHashCode.Include
   private Long id;
   private String nome;
   private String cor;

   @ManyToOne
   @JoinColumn(name = "caixa_id")

   private Caixa caixa;
}
