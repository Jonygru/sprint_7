import io.restassured.response.ValidatableResponse;
import org.example.courier.ChecksCourier;
import org.example.courier.Courier;
import org.example.courier.ApiCourier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class TestCourierWithParameterizedNegativeCase {
    private final String login;
    private final String password;
    private final String firstName;

    public TestCourierWithParameterizedNegativeCase(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    private final ApiCourier endpoint = new ApiCourier();
    private final ChecksCourier check = new ChecksCourier();
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"zekich", null, "Oleg"},
                {null, "12345", "Oleg"},
                {null, null, "Oleg"},
                {null, "12345", null},
                {"zekich", null, null},
                {null, null, null},
                {"zekich", "", "Oleg"},
                {"", "12345", "Oleg"},
                {"", "", "Oleg"},
                {"", "12345", ""},
                {"zekich", "", ""},
                {"", "", ""},
        };
    }

    @Test
    public void createCourierNotHaveAnyFields() {
        Courier courierWithLoginAndPassword = new Courier(login, password, firstName);
        ValidatableResponse courierResponse = endpoint.createCourier(courierWithLoginAndPassword);
        check.createCourierNotHaveObligatoryField(courierResponse);
    }
}
