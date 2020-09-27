package application.view.navigation;

import javafx.scene.layout.HBox;

public class NavigationParent extends HBox  {
    private static NavigationParent instance = null;

    private NavigationParent() {
        // Id given to reference it in a css file
        this.setId("navigationParent");

        // Add navigation buttons here
        this.getChildren().addAll(
                LogoNavigationButton.getInstance(),
                BoardNavigationButton.getInstance(),
                PublishNavigationButton.getInstance(),
                RegisterNavigationButton.getInstance()
        );

    }

    // Singleton
    public static NavigationParent getInstance() {
        if (instance == null) {
            instance = new NavigationParent();
        }

        return instance;
    }

}
