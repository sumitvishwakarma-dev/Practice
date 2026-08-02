package com.sumitdev.SpringHibernate.model;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class Address {

    private BigDecimal houseNumber;
    private String street;
    private String area;
    private String district;
    private String state;
    private String country;


    public Address(){}

    public Address(BigDecimal houseNumber, String street,
                   String area, String district,
                   String state, String country) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.area = area;
        this.district = district;
        this.state = state;
        this.country = country;
    }

    public BigDecimal getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(BigDecimal houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
