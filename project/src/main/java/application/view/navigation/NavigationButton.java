package application.view.navigation;

import javafx.scene.control.Button;

public abstract class NavigationButton extends Button implements OnClickAction {
    protected NavigationButton() {
        this.getStyleClass().add("navigationButton");
    }

}
