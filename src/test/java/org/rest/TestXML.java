package org.rest;


import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.path.xml.element.Node;
import io.restassured.path.xml.element.NodeChildren;

import static org.hamcrest.Matchers.equalTo;


public class TestXML {


    @Test
    public void UsZipBody() {
        RestAssured.get("http://api.zippopotam.us/us/90210").then().assertThat().body("response.places.place.placeName" , equalTo("Beverly Hills"));


    }

}
