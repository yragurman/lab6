package com.yragurman.controller;

import com.yragurman.domain.ParkingSlot;
import com.yragurman.dto.ParkingSlotDto;
import com.yragurman.service.ParkingSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/parkingSlots")
@RestController
public class ParkingSlotController {

    private final ParkingSlotService parkingSlotService;

    public ParkingSlotController(ParkingSlotService parkingSlotService){
        this.parkingSlotService = parkingSlotService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ParkingSlotDto>> getAll() {
        List<ParkingSlot> parkingSlots = parkingSlotService.getAll();
        List<ParkingSlotDto> parkingSlotDtos = new ArrayList<>();
        for (ParkingSlot parkingSlot : parkingSlots) {
            ParkingSlotDto parkingSlotDto = new ParkingSlotDto(
                    parkingSlot.getId(),
                    parkingSlot.getSlotNumber(),
                    parkingSlot.getIsInvalidPlace(),
                    parkingSlot.getIsReserved(),
                    parkingSlot.getTimeCountInMinutes(),
                    parkingSlot.getParkingPriceByParkingPriceId()
            );
            parkingSlotDtos.add(parkingSlotDto);
        }
        return new ResponseEntity<>(parkingSlotDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ParkingSlotDto> getById(@PathVariable Integer id) {
        ParkingSlot parkingSlot;
        try {
            parkingSlot = parkingSlotService.getById(id);
            ParkingSlotDto parkingSlotDto = new ParkingSlotDto(
                    parkingSlot.getId(),
                    parkingSlot.getSlotNumber(),
                    parkingSlot.getIsInvalidPlace(),
                    parkingSlot.getIsReserved(),
                    parkingSlot.getTimeCountInMinutes(),
                    parkingSlot.getParkingPriceByParkingPriceId()
            );
            return new ResponseEntity<>(parkingSlotDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody ParkingSlot newParkingSlot) {
        parkingSlotService.create(newParkingSlot);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ParkingSlotDto> update(@PathVariable Integer id, @RequestBody ParkingSlot parkingSlot) {
        ParkingSlot parkingSlotOld;
        try {
            parkingSlotOld = parkingSlotService.getById(id);
            if (parkingSlotOld != null) {
                parkingSlotService.update(id, parkingSlot);
                ParkingSlotDto parkingSlotOldDto = new ParkingSlotDto(
                        parkingSlot.getId(),
                        parkingSlot.getSlotNumber(),
                        parkingSlot.getIsInvalidPlace(),
                        parkingSlot.getIsReserved(),
                        parkingSlot.getTimeCountInMinutes(),
                        parkingSlot.getParkingPriceByParkingPriceId()
                );
                return new ResponseEntity<>(parkingSlotOldDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (parkingSlotService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
