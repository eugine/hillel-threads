package ua.ithillel.generics;

public class BoundedExample {
    public <U extends Number> void inspect(U u){
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        var integerBox = new BoundedExample();
        integerBox.inspect(20.0);
    }
}
