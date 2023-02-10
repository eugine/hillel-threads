package ua.ithillel.hausaufgabe.hw7.coffee.order;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderBoardTest {

    CoffeeOrderBoard target = new CoffeeOrderBoard();

    @Test
    void shouldAddOrders() {
        var order1 = target.add("Name1");
        var order2 = target.add("Name2");

        var orders = target.getAll();
        assertThat(orders, hasSize(2));
        orders.forEach(order -> assertThat(order.name(), startsWith("Name")));
        assertThat(order2.id(), equalTo(order1.id() + 1));
    }

    @Test
    void shouldDeliverOrder() {
        var order1 = target.add("Name1");
        target.add("Name2");

        var delivered = target.deliver();
        assertThat(delivered, equalTo(order1));
        assertThat(target.getAll(), hasSize(1));
    }

    @Test
    void shouldDeliverOrderById() {
        var order1 = target.add("Name1");
        var order2 = target.add("Name2");
        var order3 = target.add("Name3");

        var delivered = target.deliver(order3.id());
        assertThat(delivered, equalTo(order3));
        assertThat(target.getAll(), hasSize(2));
    }
}