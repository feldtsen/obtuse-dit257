package application.view;

import application.ResourceLoader;
import application.controller.ClientController;
import application.model.board.Filter;
import application.view.navigation.NavigationParent;
import application.view.pages.PageParent;
import application.view.pages.board.filter.FilterBanner;
import application.view.status.StatusBanner;
import javafx.scene.layout.Priority;
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

        Region spacing = new Region();
        VBox.setVgrow(spacing, Priority.ALWAYS);



        this.getChildren().addAll(
                pageParent,

                spacing,
                StatusBanner.getInstance(),
                navigationParent
        );


        //this.setResponsiveSize(pageParent, primaryStage, .78);
        //this.setResponsiveSize(navigationParent, primaryStage, .22);

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
