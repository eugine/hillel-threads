package ua.ithillel.patterns.creational.fabricmethod.dialog;

import ua.ithillel.patterns.creational.fabricmethod.button.Button;
import ua.ithillel.patterns.creational.fabricmethod.button.WindowsButton;

public class WindowsDialog extends Dialog{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
