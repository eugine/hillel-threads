package ua.ithillel.hausaufgabe.hw6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ua.ithillel.hausaufgabe.hw6.Utils.countOccurrence;

class UtilsTest {

    @Test
    void shouldCountOccurence() {
        var list = new ArrayList<String>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        list.add("item4");
        list.add("item1");
        list.add("item1");

        assertThat(countOccurrence(list, "item1"), equalTo(3));
    }
}

