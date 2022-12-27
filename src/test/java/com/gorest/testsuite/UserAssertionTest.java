package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;


public class UserAssertionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }

// 1. Verify the if the total record is 20
        @Test
        public void getAllUser20() {

                response.body("total", equalTo(20));
            }

// 2. Verify the if the name of id = 5487 is equal to ”Hamsini Trivedi”
@Test
public void test002() {
    response.body("name", hasItem("Hamsini Trivedi"));
}

//        3. Check the single ‘Name’ in the Array list (Subhashini Talwar)
@Test
public void test003() {
    response.body("name", hasItem("Subhashini Talwar"));
}

//        4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)
@Test
public void test004() {
    response.body("name", hasItems("Mrs. Menaka Bharadwaj", "Msgr. Bodhan Guha", "Karthik Dubashi IV"));
}
//        5. Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
/*@Test
public void test005() {
    response.body("id.5471", hasItem("adiga_aanjaneya_rep@jast.org"));
}*/
    @Test
    public void test005() {
        response.body("data.findAll{it.email == 'adiga_aanjaneya_rep@jast.org'}",hasItem(hasEntry("id","5471")));
    }
//        6. Verify the status is “Active” of user name is “Shanti Bhat V”
@Test
public void test006() {
    response.body("data.findAll{it.name == 'Shanti Bhat V'}",hasItem(hasEntry("status","Active")));
}

//        7. Verify the Gender = male of user name is “Niro Prajapat”
@Test
public void test007() {
    response.body("data.findAll{it.name == 'Niro Prajapat'}",hasItem(hasEntry("gender","male")));
}

    }

