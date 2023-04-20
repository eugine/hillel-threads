package ua.ithillel.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.*;

import static ua.ithillel.utils.LogUtils.log;

public class SerializationExample {
    public static final String FILEPATH = "./out/person.ser";

    public static void main(String[] args) {
        serialize(new Person("John Doe", 30));

        var person = deserialize();
        log("Deserialized person: " + person);

        //change Person class
    }

    @SneakyThrows
    private static void serialize(Person person) {
        try (var fos = new FileOutputStream(FILEPATH);
             var oos = new ObjectOutputStream(fos)) {
            oos.writeObject(person);
        }
    }

    @SneakyThrows
    private static Person deserialize() {
        try (var fis = new FileInputStream(FILEPATH);
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

