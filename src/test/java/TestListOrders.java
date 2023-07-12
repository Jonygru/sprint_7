
import org.example.order.ApiOrder;
import org.example.order.ChecksOrder;
import org.example.order.ListOrders;
import org.junit.Test;


public class TestListOrders {
    private final ApiOrder endpoint = new ApiOrder();
    private final ChecksOrder check = new ChecksOrder();
    @Test
    public void listOrdersNotEmpty() {

        ListOrders listOrders = endpoint.getOrders();
        check.checkGetOrders(listOrders);
    }
}
