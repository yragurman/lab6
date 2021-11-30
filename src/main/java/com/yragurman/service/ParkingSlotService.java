package com.yragurman.service;

import com.yragurman.domain.ParkingSlot;
import com.yragurman.repository.ParkingSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSlotService implements AbstractService<ParkingSlot, Integer> {

    private final ParkingSlotRepository parkingSlotRepository;

    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository){
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Override
    public List<ParkingSlot> getAll() {
        return parkingSlotRepository.findAll();
    }

    @Override
    public ParkingSlot getById(Integer id) {
        return parkingSlotRepository.getOne(id);
    }

    @Override
    public ParkingSlot create(ParkingSlot newParkingSlot) {
        return parkingSlotRepository.save(newParkingSlot);
    }

    @Override
    public ParkingSlot update(Integer id, ParkingSlot parkingSlot) {
        if (parkingSlotRepository.findById(id).isPresent()) {
            return parkingSlotRepository.save(parkingSlot);
        } else {
            return null;
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (parkingSlotRepository.findById(id).isPresent()) {
            parkingSlotRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
