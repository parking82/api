package com.parking82.api.respository;

import com.parking82.api.entities.Earnings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EarningsRepository extends JpaRepository<Earnings, Long> {

}
