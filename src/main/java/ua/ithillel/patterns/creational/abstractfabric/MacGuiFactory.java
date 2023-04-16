package ua.ithillel.patterns.creational.abstractfabric;

import ua.ithillel.patterns.creational.abstractfabric.button.Button;
import ua.ithillel.patterns.creational.abstractfabric.button.MacButton;
import ua.ithillel.patterns.creational.abstractfabric.checkbox.Checkbox;
import ua.ithillel.patterns.creational.abstractfabric.checkbox.MacCheckbox;

public class MacGuiFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
