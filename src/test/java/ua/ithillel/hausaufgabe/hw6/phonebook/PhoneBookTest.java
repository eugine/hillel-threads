package ua.ithillel.hausaufgabe.hw6.phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

class PhoneBookTest {

    private static final PhoneBookRecord MARK1 = record("Mark", "12345");
    private static final PhoneBookRecord MARK2 = record("Mark", "54321");
    private static final PhoneBookRecord IVAN = record("Ivan", "23456");
    private static final PhoneBookRecord OLGA = record("Olga", "55555");

    private final PhoneBook target = new PhoneBook();

    @BeforeEach
    void setup() {
        target.add(MARK1);
        target.add(MARK2);
        target.add(IVAN);
        target.add(OLGA);
    }

    @Test
    void add() {
        var petro = record("Petro", "77777");

        target.add(petro);

        assertThat(target.getAll(), containsInAnyOrder(petro, MARK1, MARK2, IVAN, OLGA));
    }

    @Test
    void find() {
        var result = target.find("Ivan");

        assertThat(result, equalTo(IVAN));
    }

    @Test
    void findAll() {
        var result = target.findAll("Mark");

        assertThat(result, containsInAnyOrder(MARK1, MARK2));
    }

    private static PhoneBookRecord record(String name, String phoneNumber) {
        return new PhoneBookRecord(name, phoneNumber);
    }
}