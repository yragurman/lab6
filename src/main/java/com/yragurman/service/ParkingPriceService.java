package com.yragurman.service;

import com.yragurman.domain.ParkingPrice;
import com.yragurman.repository.ParkingPriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingPriceService implements AbstractService<ParkingPrice, Integer>{

    private final ParkingPriceRepository parkingPriceRepository;

    public ParkingPriceService(ParkingPriceRepository parkingPriceRepository){
        this.parkingPriceRepository = parkingPriceRepository;
    }

    @Override
    public List<ParkingPrice> getAll() {
        return parkingPriceRepository.findAll();
    }

    @Override
    public ParkingPrice getById(Integer id) {
        return parkingPriceRepository.getOne(id);
    }

    @Override
    public ParkingPrice create(ParkingPrice newParkingPrice) {
        return parkingPriceRepository.save(newParkingPrice);
    }

    @Override
    public ParkingPrice update(Integer id, ParkingPrice parkingPrice) {
        if (parkingPriceRepository.findById(id).isPresent()) {
            return parkingPriceRepository.save(parkingPrice);
        } else {
            return null;
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (parkingPriceRepository.findById(id).isPresent()) {
            parkingPriceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
