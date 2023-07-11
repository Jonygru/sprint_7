import io.restassured.response.ValidatableResponse;
import org.example.order.ApiOrder;
import org.example.order.ChecksOrder;
import org.example.order.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)

public class TestCreateOrderWithParameterized {

    private final String[] color;
    public TestCreateOrderWithParameterized(String[] color) {
        this.color = color;
    }
    private final ApiOrder endpoint = new ApiOrder();
    private final ChecksOrder check = new ChecksOrder();

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {new String[]{}},
        };
    }

    @Test
    public void createOrder() {
        Order order = new Order("Naruto", "Uchiha", "Konoha, 142 apt.", "4", "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", color);
        ValidatableResponse orderResponse = endpoint.createOrder(order);
        Integer track = check.checkCreateOrder(orderResponse);
        assert track > 0;
        endpoint.cancelOrder(track);
    }
}
