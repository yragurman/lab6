package com.yragurman.repository;

import com.yragurman.domain.ParkingPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingPriceRepository extends JpaRepository<ParkingPrice, Integer> {
}
