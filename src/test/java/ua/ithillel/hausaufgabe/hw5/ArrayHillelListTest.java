package ua.ithillel.hausaufgabe.hw5;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ArrayHillelListTest {

    @Test
    void shouldAddItem() {
        var list = new ArrayHillelList();
        list.add("a");
        assertThat(list.size(), equalTo(1));

        list.add("b");
        list.add("c");
        assertThat(list.size(), equalTo(3));
        assertThat(list.get(0), equalTo("a"));
        assertThat(list.get(1), equalTo("b"));
        assertThat(list.get(2), equalTo("c"));
    }

    @Test
    void shouldRemoteItem() {
        var list = new ArrayHillelList("a", "b", "c");
        list.remove(0);
        assertThat(list.getAll(), equalTo(new String[]{"b", "c"}));

        list = new ArrayHillelList("a", "b", "c");
        list.remove(1);
        assertThat(list.getAll(), equalTo(new String[]{"a", "c"}));

        list = new ArrayHillelList("a", "b", "c");
        list.remove(2);
        assertThat(list.getAll(), equalTo(new String[]{"a", "b"}));
    }

    @Test
    void shouldAddAndRemoteItems() {
        var list = new ArrayHillelList("a", "b", "c");
        list.add("d");
        list.remove(1);

        assertThat(list.getAll(), equalTo(new String[]{"a", "c", "d"}));
    }

    @Test
    void shouldContainItems() {
        var list = new ArrayHillelList("a", "b", "c");
        assertThat(list.contains("a"), equalTo(true));
        assertThat(list.contains("c"), equalTo(true));
        assertThat(list.contains("d"), equalTo(false));
        list.add("d");
        assertThat(list.contains("d"), equalTo(true));
    }

    @Test
    void shouldGetIndexOfAnItem() {
        var list = new ArrayHillelList("a", "b", "c");
        assertThat(list.indexOf("c"), equalTo(2));
        assertThat(list.indexOf("a"), equalTo(0));
        assertThat(list.indexOf("d"), equalTo(-1));
    }

    @Test
    void shouldGetSizeOfList() {
        var list = new ArrayHillelList("a", "b", "c");
        assertThat(list.size(), equalTo(3));
        list.add("d");
        assertThat(list.size(), equalTo(4));
        list.remove(1);
        list.remove(0);
        assertThat(list.size(), equalTo(2));
    }
}
