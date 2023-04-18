package ua.ithillel.patterns.creational.abstractfabric.button;

public class MacButton implements Button{
    @Override
    public void paint() {
        System.out.println("button paint in MacOS");
    }
}
