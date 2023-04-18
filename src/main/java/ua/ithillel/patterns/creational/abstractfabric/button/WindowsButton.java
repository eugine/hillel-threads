package ua.ithillel.patterns.creational.abstractfabric.button;

public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("button paint in windows");
    }
}
