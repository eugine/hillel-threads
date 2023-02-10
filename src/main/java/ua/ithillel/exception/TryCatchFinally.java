package ua.ithillel.exception;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            //do job
            throw new RuntimeException();
        } catch (NumberFormatException | MyException ex) {

        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("я завжди викликаюсь");
        }
    }
}
