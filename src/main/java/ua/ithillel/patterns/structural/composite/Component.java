package ua.ithillel.patterns.structural.composite;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void operation();

    public abstract void add(Component c);

    public abstract void remove(Component c);

    public abstract Component getChild(int i);
}
