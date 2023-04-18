package ua.ithillel.patterns.creational.abstractfabric;

import ua.ithillel.patterns.creational.abstractfabric.button.Button;
import ua.ithillel.patterns.creational.abstractfabric.button.WindowsButton;
import ua.ithillel.patterns.creational.abstractfabric.checkbox.Checkbox;
import ua.ithillel.patterns.creational.abstractfabric.checkbox.WindowsCheckbox;

public class WindowsGuiFactory implements GuiFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
