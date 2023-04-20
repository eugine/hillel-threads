package ua.ithillel.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.*;

public class SerializationJsonExample {
    private static final String FILEPATH = "./out/person.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        serialize(new Person("John Doe", 30));

        var person = deserialize();
        System.out.println("Deserialized person: " + person);

        //change Person class

    }

    @SneakyThrows
    private static void serialize(Person person) {
        try (var fw = new FileWriter(FILEPATH)) {
            fw.write(objectMapper.writeValueAsString(person));
        }
    }

    @SneakyThrows
    private static Person deserialize() {
        try (var fis = new FileInputStream(SerializationJsonExample.FILEPATH);
             var ois = new ObjectInputStream(fis)) {
            return (Person) ois.readObject();
        }
    }

    @Data
    @AllArgsConstructor
    public static class Person {
        private String name;
        private int age;
//        private int age2;
    }

}

