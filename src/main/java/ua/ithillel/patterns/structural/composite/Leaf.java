package ua.ithillel.patterns.structural.composite;

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("Виконую операцію на листі " + name);
    }

    @Override
    public void add(Component c) {
        throw new UnsupportedOperationException("Неможливо додати до листа.");
    }

    @Override
    public void remove(Component c) {
        throw new UnsupportedOperationException("Неможливо видалити з листа.");
    }

    @Override
    public Component getChild(int i) {
        throw new UnsupportedOperationException("Неможливо отримати дочірній елемент для листа.");
    }
}