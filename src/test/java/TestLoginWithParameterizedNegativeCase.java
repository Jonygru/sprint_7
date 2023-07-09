import io.restassured.response.ValidatableResponse;
import org.example.Checks;
import org.example.Creds;
import org.example.EndPoints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLoginWithParameterizedNegativeCase {
    private final String login;
    private final String password;
    public TestLoginWithParameterizedNegativeCase(String login, String password) {
        this.login = login;
        this.password = password;
    }
    private final EndPoints endpoints = new EndPoints();
    private final Checks check = new Checks();

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"FDJFDS", null},
                {null, "12345"},
                {null, null},
                {"", "12345"},
                {"FDJFDS", ""},
        };
    }
    @Test
    public void loginNotHaveAnyFields(){
        Creds creds = new Creds(login, password);
        ValidatableResponse response = endpoints.logIn(creds);
        check.loginNotHaveObligatoryField(response);
    }
}
