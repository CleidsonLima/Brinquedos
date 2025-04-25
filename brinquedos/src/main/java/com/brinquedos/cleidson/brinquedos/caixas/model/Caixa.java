package com.brinquedos.cleidson.brinquedos.caixas.model;


import com.brinquedos.cleidson.brinquedos.brinquedos.model.Brinquedos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String tamanho;

    @Autowired
    @OneToMany(mappedBy = "caixa")
    @JsonIgnore
    private List<Brinquedos> brinquedos;

}
