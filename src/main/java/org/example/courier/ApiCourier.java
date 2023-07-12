package org.example.courier;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.example.courier.Courier;
import org.example.courier.Creds;
import org.example.order.ListOrders;
import org.example.order.Order;
import org.example.order.OrderNumber;

import static io.restassured.RestAssured.given;

public class ApiCourier {
    public static final String BASE_URL = "http://qa-scooter.praktikum-services.ru";
    public static final String API_V_1 = "/api/v1";

    public  ValidatableResponse createCourier(Courier courier){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(courier)
                .when()
                .post(API_V_1 + "/courier")
                .then().log().all();
    }

    public  ValidatableResponse logIn(Creds creds){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(creds)
                .when()
                .post(API_V_1 + "/courier/login")
                .then().log().all();
    }
    public  ValidatableResponse deleteCourier(String id){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .delete(API_V_1 + "/courier/"+ id)
                .then().log().all();
    }

}
