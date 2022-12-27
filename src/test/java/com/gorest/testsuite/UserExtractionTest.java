package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


public class UserExtractionTest extends TestBase {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .queryParam("page","1")
                .queryParam("per_page","20")
                .get("/users")
                .then().statusCode(200);

    }

    //        1. Extract the All Ids
        @Test
        public void test001() {
            List<Integer> allID = response.extract().path("id");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("The value of limit is : " + allID);
            System.out.println("------------------End of Test---------------------------");

        }
//        2. Extract the all Names
@Test
public void test002() {
    List<Integer> allNames = response.extract().path("name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List of Ids are : " + allNames);
    System.out.println("------------------End of Test---------------------------");

}

//        3. Extract the name of 5th object
@Test
public void test003() {
    String namesOfObject = response.extract().path("[4].name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List of Ids are : " + namesOfObject);
    System.out.println("------------------End of Test---------------------------");
}

//        4. Extract the names of all object whose status = inactive
@Test
public void test004() {
    List<String> values = response.extract().path("data.findAll{it.status == 'inactive'}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The status for all object is inactive are: " + values);
    System.out.println("------------------End of Test---------------------------");
}
//        5. Extract the gender of all the object whose status = active
@Test
public void test005() {
    List<String> values1 = response.extract().path("data.findAll{it.status == 'inactive'}.gender");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The status for all object is active are: " + values1);
    System.out.println("------------------End of Test---------------------------");
}
//        6. Print the names of the object whose gender = female
@Test
public void test006() {
    List<HashMap<String,?>> values2 = response.extract().path("findAll{it.gender=='female'}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The gender for all object is female are: " + values2);
    System.out.println("------------------End of Test---------------------------");
}
//        7. Get all the emails of the object where status = inactive
@Test
public void test007() {

        List<HashMap<String,?>> values3 = response.extract().path("findAll{it.status=='inactive'}.email");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The email for all object is active are: " + values3);
    System.out.println("------------------End of Test---------------------------");
}


//        8. Get the ids of the object where gender = male
@Test
public void test008() {
    List<String> values4 = response.extract().path("data.findAll{it.gender == 'male'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The gender for all object is male are: " + values4);
    System.out.println("------------------End of Test---------------------------");
}
//        9. Get all the status
@Test
public void test009() {
    List<Integer> allStatus = response.extract().path("status");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List of Ids are : " + allStatus);
    System.out.println("------------------End of Test---------------------------");

}
//        10. Get email of the object where name = Karthik Dubashi IV
@Test
public void test010() {
    String email = response.extract().path("data.findAll{it.name == 'Karthik Dubashi IV'}.email");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The email of Karthik Dubashi IV is : " + email);
    System.out.println("------------------End of Test---------------------------");
}
//        11. Get gender of id = 5471
@Test
public void test011() {
    List<Integer> gender = response.extract().path("data.findAll{it.id == '5471'}.gender");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The gender of 5471 is : " + gender);
    System.out.println("------------------End of Test---------------------------");
}
    }

