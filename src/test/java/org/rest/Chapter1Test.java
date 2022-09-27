package org.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class Chapter1Test {

    @Test
    public void UsZipCodeStatusCode() {

        RestAssured.get("http://api.zippopotam.us/us/90210").then().assertThat().statusCode(2100);
    }

    @Test
    public void UsZipCodeResponseType() {

        RestAssured.get("http://api.zippopotam.us/us/90210").then().assertThat().contentType(ContentType.JSON);
    }


    @Test
    public void UsZipCodeLOG() {

        RestAssured.get("http://api.zippopotam.us/us/90210").then().assertThat().log().all();
    }
    @Test
    public void UsZipBody() {
        RestAssured.get("http://api.zippopotam.us/us/90210").then().assertThat().body("places[0].'place name' " , equalTo("Beverly Hills"));


}
}