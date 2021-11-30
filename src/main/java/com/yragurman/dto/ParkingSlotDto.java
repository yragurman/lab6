package com.yragurman.dto;

import com.yragurman.domain.ParkingPrice;

import javax.persistence.*;

public class ParkingSlotDto {
    private Integer id;
    private Integer slotNumber;
    private String isInvalidPlace;
    private String isReserved;
    private Integer timeCountInMinutes;
    private ParkingPrice parkingPriceByParkingPriceId;

    public ParkingSlotDto(Integer id, Integer slotNumber, String isInvalidPlace, String isReserved, Integer timeCountInMinutes, ParkingPrice parkingPriceByParkingPriceId) {
        this.id = id;
        this.slotNumber = slotNumber;
        this.isInvalidPlace = isInvalidPlace;
        this.isReserved = isReserved;
        this.timeCountInMinutes = timeCountInMinutes;
        this.parkingPriceByParkingPriceId = parkingPriceByParkingPriceId;
    }

    public ParkingSlotDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getIsInvalidPlace() {
        return isInvalidPlace;
    }

    public void setIsInvalidPlace(String isInvalidPlace) {
        this.isInvalidPlace = isInvalidPlace;
    }

    public String getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(String isReserved) {
        this.isReserved = isReserved;
    }

    public Integer getTimeCountInMinutes() {
        return timeCountInMinutes;
    }

    public void setTimeCountInMinutes(Integer timeCountInMinutes) {
        this.timeCountInMinutes = timeCountInMinutes;
    }

    public ParkingPrice getParkingPriceByParkingPriceId() {
        return parkingPriceByParkingPriceId;
    }

    public void setParkingPriceByParkingPriceId(ParkingPrice parkingPriceByParkingPriceId) {
        this.parkingPriceByParkingPriceId = parkingPriceByParkingPriceId;
    }
}
