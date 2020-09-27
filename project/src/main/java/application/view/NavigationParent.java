package application.view;

import javafx.scene.layout.HBox;

public class NavigationParent extends HBox  {
    private static NavigationParent instance = null;

    private NavigationParent() {
        this.setId("navigationParent");

    }

    public static NavigationParent getInstance() {
        if (instance == null) {
            instance = new NavigationParent();
        }

        return instance;
    }

}
