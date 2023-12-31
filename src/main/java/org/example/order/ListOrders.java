package org.example.order;

import org.example.order.AvailableStations;
import org.example.order.Orders;
import org.example.order.PageInfo;

import java.util.List;

public class ListOrders {
    private List<Orders> orders;
    private PageInfo pageInfo;
    private List<AvailableStations> availableStations;

    public ListOrders() {
    }

    public ListOrders(List<Orders> orders, PageInfo pageInfo, List<AvailableStations> availableStations) {
        this.orders = orders;
        this.pageInfo = pageInfo;
        this.availableStations = availableStations;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<AvailableStations> getAvailableStations() {
        return availableStations;
    }

    public void setAvailableStations(List<AvailableStations> availableStations) {
        this.availableStations = availableStations;
    }
}
