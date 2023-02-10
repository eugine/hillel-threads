package ua.ithillel.collections.deque;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class DequeExampleTest {
    @Test
    void creation() {
//        var deque = new LinkedList<String>();
        var deque = new ArrayDeque<String>();
//        deque.getFirst();
        var element = deque.pollFirst();

        deque.addLast("last");
        deque.addFirst("first");

        System.out.println(deque);

        //різниця?
        var element1 = deque.getFirst();
        var element2 = deque.removeFirst();

        deque.getLast();
        deque.removeLast();

        //
        deque.offerFirst("first2");
        deque.offerLast("last2");
        deque.pollFirst();
        deque.peekLast();

    }
}
