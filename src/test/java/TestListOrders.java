
import org.example.*;
import org.junit.Test;


public class TestListOrders {
    private final EndPoints endpoints = new EndPoints();
    private final Checks check = new Checks();
    @Test
    public void listOrdersNotEmpty() {

        ListOrders listOrders = endpoints.getOrders();
        check.checkGetOrders(listOrders);
    }
}
