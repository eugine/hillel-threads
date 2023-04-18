package ua.ithillel.patterns.creational.fabricmethod.button;

import ua.ithillel.patterns.creational.fabricmethod.button.Button;

public class WindowsButton implements Button {
    @Override
    public void render(int x, int y) {
        System.out.println("render windows button");
    }

    @Override
    public void onClick(String event) {
        System.out.println("onClick windows event: " + event);
    }
}
