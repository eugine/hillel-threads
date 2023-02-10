package ua.ithillel.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ua.ithillel.tdd.TDDHillelList.findXXX;

class TDDHillelListTest {

    @Test
    void shouldReturnIndexOfItem() {
        var list = new ArrayList<>();
        list.add("item");

        assertEquals(list.indexOf("no_existing_item"), -1);
        assertEquals(list.indexOf("item"), 0);
    }

    @Test
    void shouldFindXX() {
        var list = new ArrayList<String>();
        list.add("item");
        list.add("item");
        list.add("item");

        assertEquals(findXXX(list, "item"), 3);
    }
}
