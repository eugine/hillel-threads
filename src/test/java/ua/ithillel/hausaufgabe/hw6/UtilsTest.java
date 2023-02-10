package ua.ithillel.hausaufgabe.hw6;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ua.ithillel.hausaufgabe.hw6.Utils.countOccurrence;

//@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class UtilsTest {

    List<String> list;

    @BeforeEach
    void setup() {
        list = new ArrayList<>();
        //clean DB
    }


    @Test
    void shouldCountOccurrence1() {
//        var list = new ArrayList<String>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        list.add("item4");
        list.add("item1");
        list.add("item1");

        assertThat(countOccurrence(list, "item1"), equalTo(3));
    }
    @Test
    void shouldCountOccurrence2() {
//        var list = new ArrayList<String>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        list.add("item4");
        list.add("item1");
        list.add("item1");

        assertThat(countOccurrence(list, "item1"), equalTo(3));
    }


}

