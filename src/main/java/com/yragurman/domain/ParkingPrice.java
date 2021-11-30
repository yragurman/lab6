package com.yragurman.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "parking_price")
public class ParkingPrice {
    private Integer id;
    private BigDecimal morningPrice;
    private BigDecimal middayPrice;
    private BigDecimal eveningPrice;
    private BigDecimal allDayPrice;

    public ParkingPrice(Integer id, BigDecimal morningPrice, BigDecimal middayPrice, BigDecimal eveningPrice, BigDecimal allDayPrice) {
        this.id = id;
        this.morningPrice = morningPrice;
        this.middayPrice = middayPrice;
        this.eveningPrice = eveningPrice;
        this.allDayPrice = allDayPrice;
    }

    public ParkingPrice() {

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
    @Column(name = "morning_price")
    public BigDecimal getMorningPrice() {
        return morningPrice;
    }

    public void setMorningPrice(BigDecimal morningPrice) {
        this.morningPrice = morningPrice;
    }

    @Basic
    @Column(name = "midday_price")
    public BigDecimal getMiddayPrice() {
        return middayPrice;
    }

    public void setMiddayPrice(BigDecimal middayPrice) {
        this.middayPrice = middayPrice;
    }

    @Basic
    @Column(name = "evening_price")
    public BigDecimal getEveningPrice() {
        return eveningPrice;
    }

    public void setEveningPrice(BigDecimal eveningPrice) {
        this.eveningPrice = eveningPrice;
    }

    @Basic
    @Column(name = "all_day_price")
    public BigDecimal getAllDayPrice() {
        return allDayPrice;
    }
    public void setAllDayPrice(BigDecimal allDayPrice) {
        this.allDayPrice = allDayPrice;
    }

    @OneToMany(mappedBy = "parking_price" , cascade = {CascadeType.ALL})
    private List<ParkingSlot> parkingSlots;

    @Override
    public String toString() {
        return "\n\n[ id= " + id +
                ",\nmorning Price= " + morningPrice +
                ",\nmidday Price= " + middayPrice +
                ",\nevening Price= " + eveningPrice +
                ",\nall Day Price= " + allDayPrice + " ]";
    }
}
