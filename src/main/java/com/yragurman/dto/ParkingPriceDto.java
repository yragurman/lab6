package com.yragurman.dto;

import java.math.BigDecimal;

public class ParkingPriceDto {
    private Integer id;
    private BigDecimal morningPrice;
    private BigDecimal middayPrice;
    private BigDecimal eveningPrice;
    private BigDecimal allDayPrice;

    public ParkingPriceDto(Integer id, BigDecimal morningPrice, BigDecimal middayPrice, BigDecimal eveningPrice, BigDecimal allDayPrice) {
        this.id = id;
        this.morningPrice = morningPrice;
        this.middayPrice = middayPrice;
        this.eveningPrice = eveningPrice;
        this.allDayPrice = allDayPrice;
    }
    public ParkingPriceDto(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMorningPrice() {
        return morningPrice;
    }

    public void setMorningPrice(BigDecimal morningPrice) {
        this.morningPrice = morningPrice;
    }

    public BigDecimal getMiddayPrice() {
        return middayPrice;
    }

    public void setMiddayPrice(BigDecimal middayPrice) {
        this.middayPrice = middayPrice;
    }


    public BigDecimal getEveningPrice() {
        return eveningPrice;
    }

    public void setEveningPrice(BigDecimal eveningPrice) {
        this.eveningPrice = eveningPrice;
    }

    public BigDecimal getAllDayPrice() {
        return allDayPrice;
    }

    public void setAllDayPrice(BigDecimal allDayPrice) {
        this.allDayPrice = allDayPrice;
    }

}
