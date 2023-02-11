package ua.ithillel.hausaufgabe.hw7.maps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileNavigatorTest {

    private static final FileData ROOT_BIN = new FileData("bin", 1000L, "/root");
    private static final FileData ROOT_LIB32 = new FileData("lib32", 2000L, "/root");
    private static final FileData ROOT_OPT = new FileData("opt", 3000L, "/root");
    private static final FileData ETC_NONE = new FileData("none.txt", 1001L, "/etc");


    private final FileNavigator target = new FileNavigator();

    @BeforeEach
    void setUp() {
        target.add("/root", ROOT_BIN);
        target.add("/root", ROOT_LIB32);
        target.add("/root", ROOT_OPT);
        target.add("/etc", ETC_NONE);
    }

    @Test
    void shouldAddFiles() {
        var fs = target.getAll();

        assertThat(fs.size(), equalTo(2));
        assertThat(fs.get("/root"), containsInAnyOrder(ROOT_BIN, ROOT_OPT, ROOT_LIB32));
        assertThat(fs.get("/etc"), equalTo(List.of(ETC_NONE)));
    }

    @Test
    void shouldFindFile() {
        var files = target.find("/root");
        assertThat(files,containsInAnyOrder(ROOT_BIN, ROOT_OPT, ROOT_LIB32));
    }

    @Test
    void shouldFilterBySizeFile() {
        var files = target.filterBySize("/root", 1999L);
        assertThat(files,equalTo(List.of(ROOT_BIN)));
    }

    @Test
    void shouldFilterAllBySizeFile() {
        var files = target.filterAllBySize(1001L);
        assertThat(files,containsInAnyOrder(ROOT_BIN, ETC_NONE));
    }

    @Test
    void shouldRemovePath() {
        var removed = target.remove("/etc");

        assertThat(removed, equalTo(List.of(ETC_NONE)));

        var fs = target.getAll();
        assertThat(fs.size(), equalTo(1));
        assertThat(fs.get("/root"), containsInAnyOrder(ROOT_BIN, ROOT_OPT, ROOT_LIB32));
        assertThat(fs.containsKey("/etc"), equalTo(false));
    }

    @Test
    void shouldSortBySize() {
        var sorted = target.sortBySize();

        assertThat(sorted, equalTo(List.of(ROOT_BIN, ETC_NONE, ROOT_LIB32, ROOT_OPT)));
    }

    @Test
    void shouldThrowExceptionForPathInconsistency() {
        var exception = assertThrows(FileInconsistencyException.class, () -> new FileNavigator().add("/wrong", ETC_NONE));
        assertThat(exception.getFsPath(), equalTo("/wrong1"));
        assertThat(exception.getFile(), equalTo(ETC_NONE));
    }

}