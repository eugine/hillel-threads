package ua.ithillel.exception;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            //do job
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("я завжди викликаюсь");
        }
    }
}
