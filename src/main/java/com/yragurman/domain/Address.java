package com.yragurman.domain;

import javax.persistence.*;

@Table(name = "address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "adress_name")
    private String adressName;

    @Column(name = "post_index")
    private Integer postIndex;

    public Address(Integer id, String country, String city, String adressName, Integer postIndex) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.adressName = adressName;
        this.postIndex = postIndex;
    }

    public Address() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdressName() {
        return adressName;
    }

    public void setAdressName(String adressName) {
        this.adressName = adressName;
    }

    public Integer getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(Integer postIndex) {
        this.postIndex = postIndex;
    }

    @Override
    public String toString() {
        return "\n\n[ id= " + id +
                ",\ncountry= " + country +
                ",\ncity= " + city +
                ",\nadress Name= " + adressName +
                ",\npostIndex= " + postIndex + " ]";
    }
}
