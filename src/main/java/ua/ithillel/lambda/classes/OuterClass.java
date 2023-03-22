package ua.ithillel.lambda.classes;

import lombok.ToString;

@ToString
public class OuterClass {
    private final String outerName;

    public OuterClass(String name) {
        this.outerName = name;
    }

    @ToString
    public class InnerClass {
        private final String innerName;

        public InnerClass(String name) {
//            this.innerName = outerName + "-" + name;
            this.innerName = outerName + "-" + name;
        }
    }

    @ToString
    public static class StaticNestedClass {
        private final String staticName;

        public StaticNestedClass(String name) {
//            this.staticName = outerName + "-" + name;
            this.staticName = name;
        }
    }

    public static void main(String[] args) {
        var outer = new OuterClass("outer");
//        var inner = new InnerClass("inner");
//        var staticNested = new StaticNestedClass("static");

        System.out.println(outer);
//        System.out.println(inner);
//        System.out.println(staticNested);
    }
}
