package com.yragurman.domain;

import javax.persistence.*;

@Entity
@Table(name = "parking_slot")
public class ParkingSlot {
    private Integer id;
    private Integer slotNumber;
    private String isInvalidPlace;
    private String isReserved;
    private Integer timeCountInMinutes;
    private ParkingPrice parkingPriceByParkingPriceId;

    public ParkingSlot(Integer id, Integer slotNumber, String isInvalidPlace, String isReserved, Integer timeCountInMinutes, ParkingPrice parkingPriceByParkingPriceId) {
        this.id = id;
        this.slotNumber = slotNumber;
        this.isInvalidPlace = isInvalidPlace;
        this.isReserved = isReserved;
        this.timeCountInMinutes = timeCountInMinutes;
        this.parkingPriceByParkingPriceId = parkingPriceByParkingPriceId;
    }

    public ParkingSlot() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "slot_number")
    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    @Basic
    @Column(name = "is_invalid_place")
    public String getIsInvalidPlace() {
        return isInvalidPlace;
    }

    public void setIsInvalidPlace(String isInvalidPlace) {
        this.isInvalidPlace = isInvalidPlace;
    }

    @Basic
    @Column(name = "is_reserved")
    public String getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(String isReserved) {
        this.isReserved = isReserved;
    }

    @Basic
    @Column(name = "time_count_in_minutes")
    public Integer getTimeCountInMinutes() {
        return timeCountInMinutes;
    }

    public void setTimeCountInMinutes(Integer timeCountInMinutes) {
        this.timeCountInMinutes = timeCountInMinutes;
    }


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parking_price_id", referencedColumnName = "id", nullable = false)
    public ParkingPrice getParkingPriceByParkingPriceId() {
        return parkingPriceByParkingPriceId;
    }

    public void setParkingPriceByParkingPriceId(ParkingPrice parkingPriceByParkingPriceId) {
        this.parkingPriceByParkingPriceId = parkingPriceByParkingPriceId;
    }
    @Override
    public String toString() {
        return "\n\n[ id= " + id +
                ",\nslot Number= " + slotNumber +
                ",\nis Invalid Place= " + isInvalidPlace +
                ",\nis Reserved= " + isReserved +
                ",\ntime Count In Minutes= " + timeCountInMinutes +
                ",\nparking Price= " + parkingPriceByParkingPriceId +" ]";
    }
}

