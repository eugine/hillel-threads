package ua.ithillel.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private final List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("Виконую операцію на складному компоненті " + name);
        for (Component c : children) {
            c.operation();
        }
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }
}
