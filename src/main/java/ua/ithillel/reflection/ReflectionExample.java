package ua.ithillel.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReflectionExample {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var classFullName = "ua.ithillel.reflection.ReflectionClass";
        System.out.println("Reflection for class: " + classFullName);
        Class<?> clazz = Class.forName(classFullName);

        information(clazz);
//        invoke(clazz);

    }

    private static void information(Class<?> clazz) {
        int modifiers = clazz.getModifiers();
        System.out.println("Class modifiers: " + modifiers);
        System.out.println("isPublic: " + Modifier.isPublic(modifiers));

        var methods = Arrays.asList(clazz.getDeclaredMethods());
        System.out.println("Methods: ");
        methods.forEach(method -> System.out.println(" - " + method));

        var selectedMethod = methods.stream()
                .filter(method -> method.getDeclaredAnnotations().length > 0)
                .findFirst()
                .orElseThrow();
        var annotations = Arrays.asList(selectedMethod.getDeclaredAnnotations());
        System.out.println("Annotations: ");
        annotations.forEach(annotation -> System.out.println(" - " + annotation));
        //where is @SuppressWarning annotations?

        var parameters = Arrays.asList(selectedMethod.getParameters());
        System.out.println("Parameters: ");
        parameters.forEach(parameter -> System.out.println(" - " + parameter));

        var parameterTypes = Arrays.asList(selectedMethod.getParameterTypes());
        System.out.println("Parameter types: ");
        parameterTypes.forEach(type -> System.out.println(" - " + type));

        var fields = Arrays.asList(clazz.getDeclaredFields());
        System.out.println("Fields: ");
        fields.forEach(field -> System.out.println(" - " + field));
    }

    @SneakyThrows
    private static void invoke(Class<?> clazz) {
        var instance = clazz.getConstructor(String.class).newInstance("name_in_constructor");

        var method = Stream.of(clazz.getDeclaredMethods())
                .filter(m -> m.getName().equals("toUpperCase"))
                .findFirst()
                .orElseThrow();
        var result = method.invoke(instance, "hillel");
        System.out.println("Result of method invocation: " + result);

//        var field = Stream.of(clazz.getDeclaredFields())
//                .filter(f -> f.getName().equals("name"))
//                .findFirst()
//                .orElseThrow();
//        System.out.println("Field value: " + field.get(instance));
        //
    }


}
