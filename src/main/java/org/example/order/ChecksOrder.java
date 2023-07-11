package org.example.order;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.example.order.ListOrders;
import org.example.order.Orders;

import java.util.List;

public class ChecksOrder {
    @Step("Create order")
    public Integer checkCreateOrder(ValidatableResponse response){
        Integer track = response.assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .extract().path("track");
        return track;
    }
    @Step("Check orders not null")
    public void checkGetOrders(ListOrders listOrders){
        List<Orders> resultOrders = listOrders.getOrders();
        boolean result = resultOrders.isEmpty();
        assert result == false;

    }
}
