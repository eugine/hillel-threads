package ua.ithillel.hausaufgabe.hw7.coffee.order;

import java.util.*;

/*
1. Створити клас CoffeeOrderBoard. Клас є цифровим поданням черги замовлень у кав'ярні.
Цей клас містить список замовлень.

2. Створити клас Order. Клас є цифровим поданням замовлення. Даний клас містить номер замовлення та ім'я людини, що його замовила.

3. Реалізувати метод add у класі CoffeeOrderBoard. Даний метод додає нове замовлення та надає замовленню номер (натуральний порядок).
Натуральний порядок (natural ordering) означає, що й у останнього замовлення номер 86, то наступний буде 87.
Не може бути такої ситуації, що номер повторюється у межах одного об'єкта типу CoffeeOrderBoard.

4. Реалізувати метод deliver у класі CoffeeOrderBoard. Цей метод видає найближче у черзі замовлення. Видача супроводжується видаленням замовлення зі списку.

5. Реалізувати метод deliver у класі CoffeeOrderBoard. Даний метод видає замовлення з певним номером. Видача супроводжується видаленням замовлення зі списку.
Даний метод обробляє ситуацію, коли замовлення, що надійшло пізніше, готове раніше.
 */
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
            if (order.id() == id) {
                searchedOrder = order;
                break;
            }
        }
        orders.remove(searchedOrder);
        return searchedOrder;
    }

    public Collection<Order> getAll() {
        return Collections.unmodifiableCollection(orders);
    }


}


