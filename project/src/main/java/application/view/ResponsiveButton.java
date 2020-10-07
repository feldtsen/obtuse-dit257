package application.view;

import javafx.scene.control.Button;

public abstract class ResponsiveButton extends Button {
    private final static double VALUE_THAT_NEVER_GETS_EXCEEDED_BY_SCREEN_RESOLUTION = 100000000;

    public ResponsiveButton() {
        // Setting the value of height and width to a number larger than its container
        // makes it occupy the available space, and forces the buttons to share
        // the available space
        this.setPrefHeight(VALUE_THAT_NEVER_GETS_EXCEEDED_BY_SCREEN_RESOLUTION);
        this.setPrefWidth(VALUE_THAT_NEVER_GETS_EXCEEDED_BY_SCREEN_RESOLUTION);
    }
}
