package com.yragurman.domain;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    private Integer id;
    private String vehicleNumber;
    private String isRegularCustomer;
    private String contactNumber;

    public Customer(Integer id, String vehicleNumber, String isRegularCustomer, String contactNumber) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.isRegularCustomer = isRegularCustomer;
        this.contactNumber = contactNumber;
    }

    public Customer() {

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
    @Column(name = "vehicle_number")
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Basic
    @Column(name = "is_regular_customer")
    public String getIsRegularCustomer() {
        return isRegularCustomer;
    }

    public void setIsRegularCustomer(String isRegularCustomer) {
        this.isRegularCustomer = isRegularCustomer;
    }

    @Basic
    @Column(name = "contact_number")
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "\n\n[ id= " + id +
                ",\nvehicle Number= " + vehicleNumber +
                ",\nis Regular Customer= " + isRegularCustomer +
                ",\ncontact Number= " + contactNumber + " ]";
    }
}
