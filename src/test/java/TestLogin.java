import io.restassured.response.ValidatableResponse;
import org.example.*;
import org.junit.Test;


public class TestLogin {
    private final CourierGenerator generatorCorier = new CourierGenerator();
    private final EndPoints endpoints = new EndPoints();
    private final Checks check = new Checks();

    Courier courier = generatorCorier.generic();
    Creds creds = Creds.from(courier);
    @Test
    public void loginSaccess(){
        endpoints.createCourier(courier);
        ValidatableResponse response = endpoints.logIn(creds);
        Integer id = check.loginSuccess(response);
        assert id > 0;
        endpoints.deleteCourier(id.toString()); // Удаляем нашего курьера
    }

    @Test
    public void loginNotRealCreeds(){
        Creds creds = new Creds("#@FDJFDS", "143124");
        ValidatableResponse response = endpoints.logIn(creds);
        check.loginNotRealCreds(response);
    }


}
