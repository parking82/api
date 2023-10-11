package com.parking82.api.respository;

import com.parking82.api.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Spot, Long> {

}
