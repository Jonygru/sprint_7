import io.restassured.response.ValidatableResponse;
import org.example.*;
import org.junit.Test;


public class TestCourierCreate {

    private final CourierGenerator generatorCorier = new CourierGenerator();
    private final EndPoints endpoints = new EndPoints();
    private final Checks check = new Checks();

    @Test
    public void createCourierWithAllFields() {
        Courier courier = generatorCorier.generic();
        ValidatableResponse courierResponse = endpoints.createCourier(courier);
        check.createCourierSaccess(courierResponse);
        Creds creds = Creds.from(courier);
        Integer id = endpoints.logIn(creds).extract().path("id");
        endpoints.deleteCourier(id.toString());
    }

    @Test
    public void createCloneCourier() {
        Courier courier = generatorCorier.generic();
        endpoints.createCourier(courier);
        ValidatableResponse courierResponse = endpoints.createCourier(courier);
        check.createCloneCourierNegative(courierResponse);
        Creds creds = Creds.from(courier);
        Integer id = endpoints.logIn(creds).extract().path("id");
        endpoints.deleteCourier(id.toString());
    }
    @Test
    public void createCourierWithLoginAndPassword() {
        Courier courierWithLoginAndPassword = new Courier("zekich", "12345", null);
        ValidatableResponse courierResponse = endpoints.createCourier(courierWithLoginAndPassword);
        check.createCourierSaccess(courierResponse);
        Creds creds = new Creds("zekich", "12345");
        Integer id = endpoints.logIn(creds).extract().path("id");
        endpoints.deleteCourier(id.toString());
    }


}
