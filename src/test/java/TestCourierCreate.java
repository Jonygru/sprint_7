import io.restassured.response.ValidatableResponse;
import org.example.courier.*;
import org.junit.After;
import org.junit.Test;


public class TestCourierCreate {

    private final CourierGenerator generatorCorier = new CourierGenerator();
    private final ApiCourier endpoint = new ApiCourier();
    private final ChecksCourier check = new ChecksCourier();
    Courier courier;

    @Test
    public void createCourierWithAllFields() {
        courier = generatorCorier.generic();
        ValidatableResponse courierResponse = endpoint.createCourier(courier);
        check.createCourierSaccess(courierResponse);
    }

    @Test
    public void createCloneCourier() {
        courier = generatorCorier.generic();
        endpoint.createCourier(courier);
        ValidatableResponse courierResponse = endpoint.createCourier(courier);
        check.createCloneCourierNegative(courierResponse);
    }
    @Test
    public void createCourierWithLoginAndPassword() {
        courier = new Courier("zekich", "12345", null);
        ValidatableResponse courierResponse = endpoint.createCourier(courier);
        check.createCourierSaccess(courierResponse);
    }
    @After
    public void deleteCourier(){
        Creds creds = Creds.from(courier);
      Integer id = endpoint.logIn(creds).extract().path("id");
       endpoint.deleteCourier(id.toString());
    }

}
