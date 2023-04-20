package ua.ithillel.server.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static ua.ithillel.utils.LogUtils.log;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        var serverSocket = new ServerSocket(8080);
        log("Listening on port 8080...");

        while (true) {
            var clientSocket = serverSocket.accept();
            handleRequest(clientSocket);
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            log(inputLine);
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

