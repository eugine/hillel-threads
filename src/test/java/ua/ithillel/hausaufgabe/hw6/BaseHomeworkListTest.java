package ua.ithillel.hausaufgabe.hw6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

abstract class BaseHomeworkListTest {

    public abstract HomeworkList target();

    @Test
    void shouldCountOccurrence() {
        var list = List.of("item1", "item2", "item3", "item4", "item1", "item1");

        assertThat(target().countOccurrence(list, "item1"), equalTo(3));
    }

    @Test
    void shouldConvertToList() {
        var array = new String[]{"one", "two", "three"};

        assertThat(target().toList(array), equalTo(List.of("one", "two", "three")));
    }

    @Test
    void shouldFindUnique() {
        var list = List.of("1", "2", "3", "4", "1", "2");

        var result = target().findUnique(list);
        assertThat(result, containsInAnyOrder("1", "2", "3", "4"));
    }

    @Test
    void shouldCalcOccurrence() {
        var list = List.of("bird", "fox", "cat", "bird");

        var result = target().calcOccurrence(list);
        assertThat(result, containsInAnyOrder("bird: 2", "fox: 1", "cat: 1"));
    }

    @Test
    void shouldFindOccurrence() {
        var list = List.of("bird", "fox", "cat", "bird");

        var result = target().findOccurrence(list);
        assertThat(result, containsInAnyOrder(occurrence("bird", 2), occurrence("fox", 1), occurrence("cat", 1)));
    }

    public NameOccurrence occurrence(String name, int count) {
        return new NameOccurrence(name, count);
    }
}

