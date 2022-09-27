package org.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeSerliazation {


    @Test
            public void FromJsonToJava(){
    Location location1 = RestAssured.given().when().get("http://api.zippopotam.us/us/90210").as(Location.class);

        Assert.assertEquals(location1.getPlaces().get(0).getPlaceName(),"Beverly Hills");

    }

    @Test
    public void FromJavaToJson() {

        Location location2 = new Location();
       // location2.setCountry("Netherlands");

       RestAssured.given().contentType(ContentType.JSON).body(location2).  log().body().
               when().
               post("http://localhost:9876/lv/1050").  then().
               assertThat().
               statusCode(200);



    }

}
