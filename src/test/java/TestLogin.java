import io.restassured.response.ValidatableResponse;
import org.example.courier.*;
import org.junit.Test;


public class TestLogin {
    private final CourierGenerator generatorCorier = new CourierGenerator();
    private final ApiCourier endpoint = new ApiCourier();
    private final ChecksCourier check = new ChecksCourier();

    Courier courier = generatorCorier.generic();
    Creds creds = Creds.from(courier);
    @Test
    public void loginSaccess(){
        endpoint.createCourier(courier);
        ValidatableResponse response = endpoint.logIn(creds);
        Integer id = check.loginSuccess(response);
        assert id > 0;
        endpoint.deleteCourier(id.toString());
    }

    @Test
    public void loginNotRealCreeds(){
        Creds creds = new Creds("#@FDJFDS", "143124");
        ValidatableResponse response = endpoint.logIn(creds);
        check.loginNotRealCreds(response);
    }


}
