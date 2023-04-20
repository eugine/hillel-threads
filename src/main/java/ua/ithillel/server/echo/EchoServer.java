package ua.ithillel.server.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

import static ua.ithillel.utils.LogUtils.log;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        log("Connection successful");
        var serverSocket = new ServerSocket(8080);

        log("Waiting for connection...");
        var clientSocket = serverSocket.accept();

        log("Connection successful");
        log("Waiting for input...");

        var out = new PrintWriter(clientSocket.getOutputStream(), true);
        var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        // Читаємо вхідні дані та надсилаємо їх назад
        while ((inputLine = in.readLine()) != null) {
            log("Received: " + inputLine);
            out.println(inputLine);
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
