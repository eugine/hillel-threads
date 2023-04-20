package ua.ithillel.server.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static ua.ithillel.utils.LogUtils.log;

public class EchoClient {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);

        var echoSocket = new Socket(SERVER_HOST, SERVER_PORT);
        var out = new PrintWriter(echoSocket.getOutputStream(), true);
        var in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));


        String userInput;
        while ((userInput = scanner.nextLine()) != null) {
            out.println(userInput);
            log("Server: " + in.readLine());
        }
    }
}
