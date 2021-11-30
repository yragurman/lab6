package com.yragurman.controller;

import com.yragurman.domain.ParkingPrice;
import com.yragurman.dto.ParkingPriceDto;
import com.yragurman.service.ParkingPriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/parkingPrices")
@RestController
public class ParkingPriceController {
    private final ParkingPriceService parkingPriceService;

    public ParkingPriceController(ParkingPriceService parkingPriceService){
        this.parkingPriceService = parkingPriceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ParkingPriceDto>> getAll() {
        List<ParkingPrice> parkingPrices = parkingPriceService.getAll();
        List<ParkingPriceDto> parkingPriceDtos = new ArrayList<>();
        for (ParkingPrice parkingPrice : parkingPrices) {
            ParkingPriceDto parkingPriceDto = new ParkingPriceDto(
                    parkingPrice.getId(),
                    parkingPrice.getMorningPrice(),
                    parkingPrice.getMiddayPrice(),
                    parkingPrice.getEveningPrice(),
                    parkingPrice.getAllDayPrice()
            );
            parkingPriceDtos.add(parkingPriceDto);
        }
        return new ResponseEntity<>(parkingPriceDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ParkingPriceDto> getById(@PathVariable Integer id) {
        ParkingPrice parkingPrice;
        try {
            parkingPrice = parkingPriceService.getById(id);

            ParkingPriceDto parkingPriceDto = new ParkingPriceDto(
                    parkingPrice.getId(),
                    parkingPrice.getMorningPrice(),
                    parkingPrice.getMiddayPrice(),
                    parkingPrice.getEveningPrice(),
                    parkingPrice.getAllDayPrice()
            );
            return new ResponseEntity<>(parkingPriceDto, HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody ParkingPrice newParkingPrice) {
        parkingPriceService.create(newParkingPrice);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ParkingPriceDto> update(@PathVariable Integer id, @RequestBody ParkingPrice parkingPrice) {
        ParkingPrice parkingPriceOld;
        try {
            parkingPriceOld = parkingPriceService.getById(id);

            if (parkingPriceOld != null) {
                parkingPriceService.update(id, parkingPrice);
                ParkingPriceDto parkingPriceOldDto = new ParkingPriceDto(
                        parkingPriceOld.getId(),
                        parkingPriceOld.getMorningPrice(),
                        parkingPriceOld.getMiddayPrice(),
                        parkingPriceOld.getEveningPrice(),
                        parkingPriceOld.getAllDayPrice()
                );
                return new ResponseEntity<>(parkingPriceOldDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (parkingPriceService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
