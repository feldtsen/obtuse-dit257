package application.view;

import application.ResourceLoader;
import application.view.navigation.NavigationParent;
import application.view.pages.PageParent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class RootParent extends HBox {
    private static RootParent instance = null;

    private RootParent(Stage stage) {
        NavigationParent navigationParent = NavigationParent.getInstance();
        PageParent pageParent = PageParent.getInstance();

        this.getStylesheets().add(ResourceLoader.stylesheet);

        this.setId("rootParent");


        this.getChildren().addAll(
                navigationParent,
                pageParent
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
