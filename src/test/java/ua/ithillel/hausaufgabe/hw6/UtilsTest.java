package ua.ithillel.hausaufgabe.hw6;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    void shouldCountOccurence() {
        List<String> list = List.of();
        list.add("item1");

        assertEquals(list.toArray()[0], "item1");

        list.add("item2");
        list.add("item3");
        list.add("item4");
        list.add("item1");
        list.add("item1");

        assertEquals(3, Utils.countOccurrence(list, "item1"));
    }
}

        /*
. Створити метод countOccurance, що приймає на вхід рядковий список як параметр і довільний рядок.
Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
 Порахувати скільки разів зустрічається переданий рядок як другий аргумент.
 */
