package ua.ithillel.patterns.creational.abstractfabric;

import ua.ithillel.patterns.creational.abstractfabric.button.Button;
import ua.ithillel.patterns.creational.abstractfabric.checkbox.Checkbox;

public interface GuiFactory {

    Button createButton();
    Checkbox createCheckbox();

}
