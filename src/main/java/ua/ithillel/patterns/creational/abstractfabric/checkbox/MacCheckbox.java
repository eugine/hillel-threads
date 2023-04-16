package ua.ithillel.patterns.creational.abstractfabric.checkbox;

public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("checkbox paint in MacOS");
    }
}
