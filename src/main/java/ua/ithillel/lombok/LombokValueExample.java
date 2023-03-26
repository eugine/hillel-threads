package ua.ithillel.lombok;

import lombok.Value;

@Value
public class LombokValueExample {
    String name;
    int age;

    public static void main(String[] args) {
        var value = new LombokValueExample("name", 10);

        value.getAge();
        value.getName();
//        value.age = 15;
    }
}
