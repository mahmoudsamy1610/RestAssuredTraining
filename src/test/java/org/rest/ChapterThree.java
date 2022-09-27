package org.rest;


import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class ChapterThree {


    @DataProvider(name = "params")

    public static Object[][] Data() {
        String[][] Data = new String[][] {
                {"us","90210","Beverly Hills"},
                {"us","90210","Schenectady"},
                {"ca","B2R","Waverley"}
        };

        return Data;
    }


    @Test(dataProvider = "params")
    public void UsZipCodeLOG(String Country, String ZIP ,String PlaceName) {

        RestAssured.
                given().pathParam("CO",Country ).pathParam("Z" , ZIP).
                when().get("http://api.zippopotam.us/{CO}/{Z}").
                then().log().body();
    }


    @Test(dataProvider = "params")
    public void UsZipCodeDataDriven(String Country, String ZIP, String PlaceName ) {

       RestAssured.
               given().pathParam("CO",Country ).pathParam("Z" , ZIP).
               when().get("http://api.zippopotam.us/{CO}/{Z}").
                then().assertThat().body("places[0].'place name' " , equalTo(PlaceName));
    }



}
