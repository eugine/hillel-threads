package ua.ithillel.patterns.creational.fabricmethod.dialog;

import ua.ithillel.patterns.creational.fabricmethod.button.Button;
import ua.ithillel.patterns.creational.fabricmethod.button.HtmlButton;

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
