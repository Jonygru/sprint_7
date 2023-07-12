package org.example.courier;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.example.order.ListOrders;
import org.example.order.Orders;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class ChecksCourier {
    @Step("Create courier")
    public void createCourierSaccess(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("ok", equalTo(true));

    }
    @Step("Create clone courier")
    public void createCloneCourierNegative(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_CONFLICT)
                .body("message", equalTo("Этот логин уже используется"));

    }
    @Step("Not create courier")
    public void createCourierNotHaveObligatoryField(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));

    }
    @Step("Success logIn")
    public Integer loginSuccess(ValidatableResponse response){
        Integer id = response.assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().path("id");
        return id;
    }
    @Step("LogIn with not real creds")
    public void loginNotRealCreds(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body("message", equalTo("Учетная запись не найдена"));
    }
    @Step("LogIn when not have obligatory field")
    public void loginNotHaveObligatoryField(ValidatableResponse response){
        response.assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("message", equalTo("Недостаточно данных для входа"));
    }

}
