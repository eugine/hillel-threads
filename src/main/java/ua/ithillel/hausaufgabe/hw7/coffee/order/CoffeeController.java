package ua.ithillel.hausaufgabe.hw7.coffee.order;

public class CoffeeController {

    public static void main(String[] args) {
        var board = new CoffeeOrderBoard();
        board.add("Name 1");

        var orders = board.getAll();
        orders.add(new Order(10, "Name 2"));
    }
}
