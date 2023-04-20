package ua.ithillel.hausaufgabe.socket.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ua.ithillel.hausaufgabe.socket.model.HeroDto;
import ua.ithillel.hausaufgabe.socket.server.hero.HeroService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.stream.Collectors;

import static ua.ithillel.utils.LogUtils.log;

@RequiredArgsConstructor
public class HeroClientHandler implements Runnable {
    private final Socket clientSocket;
    private final HeroService heroService;
    private final ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public void run() {
        log("Connection successful");
        log("Waiting for input...");

        var out = new PrintWriter(clientSocket.getOutputStream(), true);
        var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        boolean running = true;
        while (running && (inputLine = in.readLine()) != null) {
            log("Received: " + inputLine);
            var parts = inputLine.split(" ");
            var command = Arrays.stream(parts).findFirst()
                    .map(String::toLowerCase)
                    .map(String::trim)
                    .orElse("unknown");
            var arguments = Arrays.stream(parts)
                    .skip(1)
                    .collect(Collectors.joining(" "));

            switch (command) {
                case "-exit" -> running = false;
                case "-name" -> heroService.findByName(arguments)
                        .map(this::convertToString)
                        .ifPresentOrElse(out::println, () -> out.println("Hero not found: " + arguments));
                default -> out.println("Unknown command: " + command);
            }
        }
        log("Closing handler");

        out.close();
        in.close();
        clientSocket.close();
    }

    @SneakyThrows
    private String convertToString(HeroDto dto) {
        return objectMapper.writeValueAsString(dto);
    }
}
