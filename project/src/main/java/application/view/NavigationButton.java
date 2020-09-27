package application.view;

import javafx.scene.control.Button;

public abstract class NavigationButton extends Button implements OnClickAction{
    protected NavigationButton() {
        this.setId("navigationButton");
        this.setHeight(Double.MAX_VALUE);
        this.setWidth(Double.MAX_VALUE);
    }
}
