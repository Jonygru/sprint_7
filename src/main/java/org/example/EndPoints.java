package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class EndPoints {
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
    public  ValidatableResponse createOrder(Order order){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(API_V_1 + "/orders")
                .then().log().all();

   }
    public  ValidatableResponse cancelOrder(Integer track){
        OrderNumber orderNumber = new OrderNumber(track);
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(orderNumber)
                .when()
                .put(API_V_1 + "/orders/cancel")
                .then().log().all();
    }
    public  ListOrders getOrders(){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(API_V_1 + "/orders")
                .body().as(ListOrders.class);
    }
}
