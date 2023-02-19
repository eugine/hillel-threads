package ua.ithillel.collections.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private final Map<String, List<String>> records = new HashMap<>();


    public void add(String name, String phoneNumber) {
        records.merge(name, List.of(phoneNumber), (list1, list2) -> {
            var result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        });
    }

    public String find(String name) {
        List<String> phoneNumbers = records.get(name);

        for (String phoneNumber : phoneNumbers) {
            if (phoneNumber.startsWith("066")) { //" 066"
                return phoneNumber;
            }
        }

        return null;
    }

    public List<String> findAll(String name) {
        return records.get(name);
    }

    public static void main(String[] args) {
        var phoneBook = new PhoneBook();

        phoneBook.add("Evgeniy", "123");
        phoneBook.add("Evgeniy", "555");

        System.out.println(phoneBook.records);
    }

}
