package ua.ithillel.hausaufgabe.socket.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ua.ithillel.hausaufgabe.socket.server.hero.HeroFactory;
import ua.ithillel.hausaufgabe.socket.server.hero.HeroService;

import java.net.ServerSocket;

import static ua.ithillel.utils.DataSourceUtils.hikariDataSource;
import static ua.ithillel.utils.LogUtils.log;

public class HeroServer {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final int PORT = 8080;

    public static void main(String[] args) {
        var heroService = HeroFactory.createService(hikariDataSource());
        startServer(heroService);
    }

    @SneakyThrows
    private static void startServer(HeroService heroService) {
        log("Connection successful");
        try (var serverSocket = new ServerSocket(PORT)) {
            while (true) {
                log("Waiting for connection...");
                var clientSocket = serverSocket.accept();
                log("Connection established, starting handler");
                var handler = new HeroClientHandler(clientSocket, heroService, objectMapper);
                new Thread(handler).start();
            }
        }
    }

}
