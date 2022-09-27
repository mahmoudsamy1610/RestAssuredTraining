package org.rest;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chapter4 {


        private  static RequestSpecification ReqSpec ;
        private  static ResponseSpecification ResSpec ;

    @BeforeClass
            public static void RequestBuilder() {
        RequestSpecBuilder ReqBuilder = new RequestSpecBuilder();
        ReqSpec = ReqBuilder.setBaseUri("http://api.zippopotam.us/").build();
    }

@Test
    public void ReuseSpec(){
            RestAssured.given().spec(ReqSpec).when().get("us/90210").then().assertThat().statusCode(200);
}

    @BeforeClass
    public static void ResponseBuilder() {
        ResponseSpecBuilder ResBuilder = new ResponseSpecBuilder();
        ResSpec = ResBuilder.expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }

    @Test
    public void ReuseRES(){

        RestAssured.given().spec(ReqSpec).when().get("us/90210").then().spec(ResSpec).log().body();

    }

    @Test
    public void Extract(){
        String PlaceName = RestAssured.given().spec(ReqSpec).when().get("us/90210").then().extract().path("places[0].'place name'");
        Assert.assertEquals(PlaceName,"Beverly Hills");

    }


}
