package application.view;

import application.ResourceLoader;
import application.view.navigation.NavigationParent;
import application.view.pages.PageParent;
import application.view.status.StatusBanner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RootParent extends HBox {
    private static RootParent instance = null;
    private static final VBox contentContainer = new VBox();

    private RootParent(Stage stage) {
        NavigationParent navigationParent = NavigationParent.getInstance();
        PageParent pageParent = PageParent.getInstance();
        HBox.setHgrow(pageParent, Priority.ALWAYS);
        HBox.setHgrow(contentContainer, Priority.ALWAYS);

        this.getStylesheets().add(ResourceLoader.stylesheet);

        this.setId("rootParent");

        contentContainer.getChildren().setAll(
                StatusBanner.getInstance(),
                pageParent
        );

        this.getChildren().addAll(
                navigationParent,
                contentContainer
        );


        // Trick to force the navigation bar to never change position
        // The navigation bar will be as big as the logo
        this.setResponsiveSize(pageParent, stage, .999);
        this.setResponsiveSize(navigationParent, stage, .001);

    }

    public static RootParent getInstance(Stage stage) {
        if (instance == null) {
            instance = new RootParent(stage);
        }
        return instance;
    }

    private void setResponsiveSize(Region region, Stage primaryStage, double widthPercentage) {
        region.prefWidthProperty().bind(primaryStage.widthProperty().multiply(widthPercentage));
    }

}
