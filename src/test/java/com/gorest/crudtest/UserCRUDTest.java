package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class UserCRUDTest extends TestBase {

    @Test
    public void verifyUserCreatedSuccessfully() {
        List<String> statusFor = new ArrayList<>();
        statusFor.add("Active");

        UserPojo userPojo = new UserPojo();
        userPojo.setName("Vil");
        userPojo.setGender("Male");
        userPojo.setEmail("VRav1245@gmail.com");
        userPojo.setStatus(statusFor);
        Response response = given().log().all()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .when()
                .body(userPojo)
                .post();
        response.prettyPrint();
        response.then().log().all().statusCode(201);
    }



    @Test
    public void verifyUserUpdateSuccessfully() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("ABC");
        userPojo.setEmail("abcd12@gmail.com");
        userPojo.setGender("male");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .when()
                .body(userPojo)
                .pathParam("id","11605")
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void VerifyUserDeleteSuccessfully() {


            Response response = given()
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                    .when()
                    .pathParam("id", "11526")
                    .delete("/{id}");
            response.then().statusCode(204);
            response.prettyPrint();
        }


    }
