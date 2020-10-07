package application.view.navigation;

import application.view.ResponsiveButton;

public abstract class NavigationButton extends ResponsiveButton implements OnClickAction {
    protected NavigationButton() {
        this.setId("navigationButton");
    }

}
