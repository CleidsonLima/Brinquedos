package com.brinquedos.cleidson.brinquedos.brinquedos.repositories;

import com.brinquedos.cleidson.brinquedos.brinquedos.model.Brinquedos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrinquedoRepository extends JpaRepository<Brinquedos, Long> {
}
