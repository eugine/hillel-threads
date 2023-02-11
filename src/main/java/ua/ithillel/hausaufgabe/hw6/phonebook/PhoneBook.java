package ua.ithillel.hausaufgabe.hw6.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public class PhoneBook {
    private final List<PhoneBookRecord> records = new ArrayList<>();

    public void add(PhoneBookRecord record) {
        records.add(record);
    }

    public PhoneBookRecord find(String name) {
        return records.stream()
                .filter(record -> Objects.equals(record.name(), name))
                .findFirst()
                .orElse(null);
    }

    public List<PhoneBookRecord> findAll(String name) {
        return records.stream()
                .filter(record -> Objects.equals(record.name(), name))
                .toList();
    }

    protected List<PhoneBookRecord> getAll() {
        return unmodifiableList(records);
    }
}
