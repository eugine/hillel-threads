package ua.ithillel.server.http;

import java.io.*;
import java.net.*;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        var serverSocket = new ServerSocket(8080);
        System.out.println("Listening on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleRequest(clientSocket);
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine.startsWith("GET")) {
                break;
            }
        }

        var out = new PrintWriter(clientSocket.getOutputStream(), true);

        var response = """
                HTTP/1.1 200 OK\r
                Content-Type: text/html\r
                \r
                <html><body><h1>Hello, HTML!</h1></body></html>\r
                """;

        out.println(response);

        in.close();
        out.close();
        clientSocket.close();
    }
}

