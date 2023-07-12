package org.example.order;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.example.order.ListOrders;
import org.example.order.Order;
import org.example.order.OrderNumber;

import static io.restassured.RestAssured.given;

public class ApiOrder {
    public static final String BASE_URL = "http://qa-scooter.praktikum-services.ru";
    public static final String API_V_1 = "/api/v1";
    public ValidatableResponse createOrder(Order order){
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
    public ListOrders getOrders(){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(API_V_1 + "/orders")
                .body().as(ListOrders.class);
    }
}
