package ua.ithillel.lambda.classes;

import lombok.ToString;

public class LocalClassExample {
    //    public LocalClass process(String event) {
    public Object process(String event) {
        var name = "local-process";

        class LocalClass {
            private void process(String event) {
//                System.out.println(name);
                System.out.println("LocalClass processing event: " + event);
            }
        }

        var local = new LocalClass();
        local.process("event");
        return local;
    }

    public static void main(String[] args) {
        var example = new LocalClassExample();

        var result = example.process("event");
        System.out.println(result);
        System.out.println("type: " + result.getClass());
    }
}
