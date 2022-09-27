package org.rest;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.ArrayList;
import java.util.List;


@JsonPropertyOrder({"PostCode","Country", "CountryABB", "places"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private String PostCode;
    private String Country;
    private String CountryABB;
    private List<Place> places;


    public void Locations() {

        this.PostCode = "1050";
        this.Country = "Latvia";
        this.CountryABB = "LV";

        //here we are taking an object from class places in order to deal with the "place" data type
        Place place = new Place();
        //in order to use array list of course we need to instantiate new object
        List<Place> places = new ArrayList<>();
        //and here we adding the values
        places.add(place);
        //here we are passing the values for the variable of the class ^^
        this.places = places ;
    }
    @JsonProperty("post code")
    public String getPostCode() {
        return PostCode;
    }

   @JsonProperty("post code")
    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    @JsonProperty("country")
    public String getCountry() {
        return Country;
    }
    @JsonProperty("country")
    public void setCountry(String country) {
        Country = country;
    }
    @JsonProperty("country abbreviation")
    public String getCountryABB() {
        return CountryABB;
    }
    @JsonProperty("country abbreviation")
    public void setCountryABB(String countryABB) {
        CountryABB = countryABB;
    }


    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
