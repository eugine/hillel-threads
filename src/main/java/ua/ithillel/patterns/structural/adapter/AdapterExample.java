package ua.ithillel.patterns.structural.adapter;

// --------------- бібліотека
interface LibraryRequest {
    void request();
}

class LibraryClient {
    void doJob(LibraryRequest target) {
        target.request();
    }
}

// --------------- інша бібліотека
class AnotherLibraryRequest {

    public void specificRequest() {
        System.out.println("Adaptee specific request");
    }
}

class Adapter implements LibraryRequest {
    private final AnotherLibraryRequest anotherLibraryRequest;

    public Adapter(AnotherLibraryRequest anotherLibraryRequest) {
        this.anotherLibraryRequest = anotherLibraryRequest;
    }

    public void request() {
        anotherLibraryRequest.specificRequest();
    }
}

public class AdapterExample {
    public static void main(String[] args) {
        var anotherLibraryRequest = new AnotherLibraryRequest();

        LibraryClient client = new LibraryClient();
        client.doJob(new Adapter(anotherLibraryRequest));
    }
}
