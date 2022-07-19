package com.everis.base.steps;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlaceHolderSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceHolderSteps.class);
    static private final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
//    private Response response;
    private RequestSpecBuilder builder;
    private RequestSpecification requestSpecification;
    private String bodyPost;

    Response response = RestAssured.get(BASE_URL + "posts");

    @Before
    public void init() {

        LOGGER.info(" Inicializa el constructor request ");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();

        LOGGER.info(" Inicializa el constructor response ");
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Step("obtiene lista de artículos")
    public void listPosts() {

        given().
                spec(requestSpec).
                when().
                get("posts").
                then().
                spec(responseSpec).
                and();
    }

    public void validateStatusCode(int i) {
        assertThat(lastResponse().statusCode(), is(i));
    }
    @Step("imprime la lista de artículos en consola")
    public void printList() {

        System.out.println("----------SE ESTA IMPRIMIENDO LA LISTA EN CONSOLA-------------");
        System.out.println("Body ordenado: " + response.getBody().asPrettyString());
    }

}
