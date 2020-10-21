package application.view;

import application.ResourceLoader;
import application.view.navigation.NavigationParent;
import application.view.pages.PageParent;
import application.view.status.AlertBanner;
import application.view.status.StatusBanner;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

public class RootParent extends HBox {
    private static RootParent instance = null;
    private static final VBox pageContainer = new VBox();

    private RootParent() {
        NavigationParent navigationParent = NavigationParent.getInstance();
        PageParent pageParent = PageParent.getInstance();
        StackPane rootContainer = new StackPane();

        // Makes rootContainer occupy the space given to it
        HBox.setHgrow(rootContainer, Priority.ALWAYS);

        // Load the CSS file
        this.getStylesheets().add(ResourceLoader.stylesheet);

        // The default theme
        this.getStyleClass().add("colorSchemeDark");

        // Set software default styling to reset unwanted settings
        this.getStyleClass().add("defaults");

        // Placement in the rootContainer get set relative to bottom
        rootContainer.setAlignment(Pos.BOTTOM_CENTER);

        // This container contains everything except the navigation menu on the left
        pageContainer.getChildren().setAll(
                StatusBanner.getInstance(),
                pageParent
        );

        // Add elements you want to float on the screen here
        rootContainer.getChildren().addAll(
                pageContainer,
                AlertBanner.getInstance()
        );


        // Add the elements in the order you want (left to right)
        this.getChildren().addAll(
                navigationParent,
                rootContainer
        );
    }

    // Singleton
    public static RootParent getInstance() {
        if (instance == null) {
            instance = new RootParent();
        }
        return instance;
    }

    // Currently we have two themes to swap between
    public void changeTheme() {
       if (this.getStyleClass().contains("colorSchemeDark")) {
           this.getStyleClass().remove("colorSchemeDark");
           this.getStyleClass().add("colorSchemeLight");
       } else {

           this.getStyleClass().remove("colorSchemeLight");
           this.getStyleClass().add("colorSchemeDark");
       }
    }
}
