package ua.ithillel.annotation;

import ua.ithillel.utils.LogUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class AnnotationUsage {

    @ExampleAnnotation
    public void method1() {
        LogUtils.log("method#1 execution");
    }

    public void method2() {
        LogUtils.log("method#2 execution");
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var classFullName = "ua.ithillel.annotation.AnnotationUsage";
        Class<?> clazz = Class.forName(classFullName);

        var methods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> Arrays.stream(m.getDeclaredAnnotations()).anyMatch(annotation -> annotation.annotationType().equals(ExampleAnnotation.class)))
                .toList();

        var instance = clazz.getDeclaredConstructors()[0].newInstance();
        for (var method : methods) {
            method.invoke(instance);
        }
    }
}
