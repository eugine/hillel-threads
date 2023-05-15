package ua.ithillel.reflection.test2.task27;

class TestAboutReflectionClass {

    // Виконується цей метод
    void doReflectionTest() throws Exception {
        var aClass = AboutReflectionClass.class;
        var constructor = aClass.getConstructor();
        var aboutReflectionObj = constructor.newInstance();
        var valField =  aClass.getDeclaredFields()[0];
        valField.set(aboutReflectionObj, 100);
    }

    public static void main(String[] args) throws Exception {
        new TestAboutReflectionClass().doReflectionTest();
    }
}