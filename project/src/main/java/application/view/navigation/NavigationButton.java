package application.view.navigation;

import javafx.scene.control.Button;

public abstract class NavigationButton extends Button implements OnClickAction {
    private final static double VALUE_THAT_NEVER_GETS_EXCEEDED_BY_SCREEN_RESOLUTION = 100000000;

    protected NavigationButton() {
        this.setId("navigationButton");

        // Setting the value of height and width to a number larger than its container
        // makes it occupy the available space, and forces the buttons to share
        // the available space
        this.setPrefHeight(VALUE_THAT_NEVER_GETS_EXCEEDED_BY_SCREEN_RESOLUTION);
        this.setPrefWidth(VALUE_THAT_NEVER_GETS_EXCEEDED_BY_SCREEN_RESOLUTION);
    }
}
