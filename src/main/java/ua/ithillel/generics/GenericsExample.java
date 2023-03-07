package ua.ithillel.generics;

import java.util.Map;

public class GenericsExample {

    public static void main(String[] args) {
//        var list = new ArrayList<Integer>();
//
//        list.add(1);
//        Integer value = list.get(0);
//        System.out.println(value);
        int a = 10;
        int value = doJob(a);
        double dValue = doJob(5.0);
//        String str = doJob("string");
    }

    public static <T extends Number> T doJob(T object) {
        System.out.println(object.getClass());
        return object;
    }

}
