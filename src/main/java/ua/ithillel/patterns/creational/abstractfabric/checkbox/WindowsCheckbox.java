package ua.ithillel.patterns.creational.abstractfabric.checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("checkbox paint in windows");
    }
}
