package ua.ithillel.exception;

public class Main {
    public static void main(String[] args) {

        String input = "123r";

        try {

            int result = parseInt(input);

            System.out.println(result);
        } catch (MyException ex) {
            ex.printStackTrace();
        }
        System.out.println("Все ок");

    }


    public static Integer parseInt(String input) throws MyException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new MyException("My Exception", ex);
        }
    }

}
