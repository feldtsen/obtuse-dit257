package application.view;

import application.ResourceLoader;
import application.controller.ClientController;
import application.view.navigation.NavigationParent;
import application.view.pages.PageParent;
import application.view.pages.login.AlertBanner;
import application.view.pages.login.LoginBanner;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RootParent extends VBox {
    private static RootParent instance = null;

    private RootParent(Stage primaryStage) {
        NavigationParent navigationParent = NavigationParent.getInstance();
        PageParent pageParent = PageParent.getInstance();

        this.getStylesheets().add(ResourceLoader.stylesheet);

        this.setId("rootParent");

        this.getChildren().addAll(
                pageParent,
                AlertBanner.getInstance(),
                LoginBanner.getInstance(),
                navigationParent
        );


        this.setResponsiveSize(pageParent, primaryStage, .80);
        this.setResponsiveSize(navigationParent, primaryStage, .20);

        ClientController.init();
    }

    public static RootParent getInstance(Stage primaryStage) {
        if (instance == null) {
            instance = new RootParent(primaryStage);
        }
        return instance;
    }

    private void setResponsiveSize(Region region, Stage primaryStage, double heightPercentage) {
        region.prefWidthProperty().bind(primaryStage.widthProperty());

        region.prefHeightProperty().bind(primaryStage.heightProperty().multiply(heightPercentage));
    }

}
