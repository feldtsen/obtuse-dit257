package application.view.navigation;

import javafx.scene.control.Button;

// Abstract navigation button for navigating using application side panel
public abstract class NavigationButton extends Button implements OnClickAction {
    protected NavigationButton() {
        this.getStyleClass().add("navigationButton");
    }
}
