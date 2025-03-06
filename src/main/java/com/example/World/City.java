package com.example.World;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class City {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name", length = 35)
    private String name;

    @Column(name = "CountryCode", length = 3)
    private String countryCode;

    @Column(name = "District", length = 20)
    private String district;

    @Column(name = "Population")
    private Integer population;

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
