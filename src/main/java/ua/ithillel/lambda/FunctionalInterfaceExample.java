package ua.ithillel.lambda;

import ua.ithillel.utils.LogUtils;

import java.util.function.Consumer;

//@FunctionalInterface
public interface FunctionalInterfaceExample {

    void process(String message);
//    void anotherProcess();
//    default void process() {
//        process("Message");
//    }

    static void main(String[] args) {
//        FunctionalInterfaceExample example = (message) -> LogUtils.log("Example: " + message);
//        example.process("hello");
//        example.process("worlds");
    }

}
