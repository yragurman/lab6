package com.yragurman.dto;


public class AddressDto {
    private Integer id;
    private String country;
    private String city;
    private String adressName;
    private Integer postIndex;

    public AddressDto(Integer id, String country, String city, String adressName, Integer postIndex) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.adressName = adressName;
        this.postIndex = postIndex;
    }

    public AddressDto(){

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
}
