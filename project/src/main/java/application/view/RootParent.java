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

        StackPane floatContainer = new StackPane();
        floatContainer.prefWidthProperty().bind(pageContainer.widthProperty());
        floatContainer.setPickOnBounds(true);

        HBox.setHgrow(floatContainer, Priority.ALWAYS);
        pageContainer.prefWidthProperty().bind(floatContainer.widthProperty());
        pageContainer.prefHeightProperty().bind(floatContainer.heightProperty());


        this.getStylesheets().add(ResourceLoader.stylesheet);

        this.getStyleClass().add("colorSchemeDark");

        this.getStyleClass().add("defaults");

        floatContainer.setAlignment(Pos.BOTTOM_CENTER);

        pageContainer.getChildren().setAll(
                StatusBanner.getInstance(),
                pageParent
        );

        floatContainer.getChildren().addAll(
                pageContainer,
                AlertBanner.getInstance()
        );

        this.getChildren().addAll(
                navigationParent,
                floatContainer
        );


        // Trick to force the navigation bar to never change position
        // The navigation bar will be as big as the logo

    }

    public static RootParent getInstance() {
        if (instance == null) {
            instance = new RootParent();
        }
        return instance;
    }

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
