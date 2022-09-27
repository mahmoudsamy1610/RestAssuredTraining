package org.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"PlaceName","Longitude", "State", "StateABB","Latitude"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {

        private String PlaceName;
        private String Longitude;
        private String State;
        private String StateABB;
        private String Latitude;


        public void Place() {

            this.PlaceName = "Riga";
            this.Longitude = "1"       ;
            this.State = "Riga";
            this.StateABB = "RI";
            this.Latitude = "1";
        }

    @JsonProperty("place name")
    public String getPlaceName() {
        return PlaceName;
    }
    @JsonProperty("place name")
    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }
    @JsonProperty("longitude")
    public String getLongitude() {
        return Longitude;
    }
    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        Longitude = longitude;
    }
    @JsonProperty("state")
    public String getState() {
        return State;
    }
    @JsonProperty("state")
    public void setState(String state) {
        State = state;
    }
    @JsonProperty("state abbreviation")
    public String getStateABB() {
        return StateABB;
    }
    @JsonProperty("state abbreviation")
    public void setStateABB(String stateABB) {
        StateABB = stateABB;
    }
    @JsonProperty("latitude")
    public String getLatitude() {
        return Latitude;
    }
    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        Latitude = latitude;
    }
}
