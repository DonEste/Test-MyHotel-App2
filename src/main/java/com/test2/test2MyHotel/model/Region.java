package com.test2.test2MyHotel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue
    private int regionId;
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Country> countries = new ArrayList<>();
    private String region_name;

    public Region() {
    }

    public Region(int regionId, List<Country> countries, String region_name) {
        this.regionId = regionId;
        this.region_name = region_name;
    }

    public int getCountry_id() {
        return regionId;
    }

    public void setCountry_id(int regionId) {
        this.regionId = regionId;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

}
