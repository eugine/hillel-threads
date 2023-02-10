package ua.ithillel.hausaufgabe.hw7.coffee.order;

import java.util.*;

public class CoffeeOrderBoard {

    private Deque<Order> orders = new ArrayDeque<>();
    private int counter = 1;


    public Order add(String name) {
        var order = new Order(counter++, name);
        orders.addFirst(order);
        return order;
    }

    public Order deliver() {
        return orders.removeLast();
    }

    public Order deliver(int id) {
        Order searchedOrder = null;
        for (Order order: orders) {
            if (order.getId() == id) {
                searchedOrder = order;
                break;
            }
        }
        orders.remove(searchedOrder);
        return searchedOrder;
    }

    public Collection<Order> getAll() {
        return Collections.unmodifiableCollection(orders);
//        return new ArrayList<>(orders);
//        return orders;
    }


}


