package ua.ithillel.patterns.creational.abstractfabric;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Application {
    private final GuiFactory factory;

    public void paint() {
        var button = factory.createButton();
        var checkbox = factory.createCheckbox();

        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        var factory = new MacGuiFactory();
        var application = new Application(factory);

        application.paint();
    }
}
