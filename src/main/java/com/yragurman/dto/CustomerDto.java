package com.yragurman.dto;

import javax.persistence.*;

public class CustomerDto {
    private Integer id;
    private String vehicleNumber;
    private String isRegularCustomer;
    private String contactNumber;

    public CustomerDto(Integer id, String vehicleNumber, String isRegularCustomer, String contactNumber) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.isRegularCustomer = isRegularCustomer;
        this.contactNumber = contactNumber;
    }
    public CustomerDto(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getIsRegularCustomer() {
        return isRegularCustomer;
    }

    public void setIsRegularCustomer(String isRegularCustomer) {
        this.isRegularCustomer = isRegularCustomer;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
