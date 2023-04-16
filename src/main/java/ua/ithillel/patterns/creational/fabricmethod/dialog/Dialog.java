package ua.ithillel.patterns.creational.fabricmethod.dialog;

import ua.ithillel.patterns.creational.fabricmethod.button.Button;

public abstract class Dialog {

    public void render() {
        var button = createButton();
        button.onClick("render");
        button.render(0, 0);
    }

    public abstract Button createButton();

}
