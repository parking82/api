package com.parking82.api.respository;

import com.parking82.api.entities.Financier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancierRepository extends JpaRepository<Financier, Long> {

}
