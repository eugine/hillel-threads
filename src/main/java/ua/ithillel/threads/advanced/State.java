package ua.ithillel.threads.advanced;

public class State {
    private String status;
    private int counter;

    public State(String status, int counter) {
        this.status = status;
        this.counter = counter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "State{" +
                "status='" + status + '\'' +
                ", counter=" + counter +
                '}';
    }
}
