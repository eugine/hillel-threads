package ua.ithillel.patterns.behavioral.cor;


record Request (String type, String message) {
}

abstract class Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public void handle(Request request) {
        if (next != null) {
            process(request);
            next.handle(request);
        }
    }

    protected abstract void process(Request request);
}

class ConcreteHandler1 extends Handler {
    @Override
    protected void process(Request request) {
        System.out.println("Request handled by ConcreteHandler1: " + request.message());
    }
}

class ConcreteHandler2 extends Handler {
    @Override
    protected void process(Request request) {
        System.out.println("Request handled by ConcreteHandler2: " + request.message());
    }
}

class ConcreteHandler3 extends Handler {
    @Override
    protected void process(Request request) {
        System.out.println("Request handled by ConcreteHandler3: " + request.message());
    }
}


public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        var handler1 = new ConcreteHandler1();
        var handler2 = new ConcreteHandler2();
        var handler3 = new ConcreteHandler3();

        handler1.setNext(handler2);
        handler2.setNext(handler3);

        var request = new Request("type2", "Request message");
        handler1.handle(request);
    }
}
