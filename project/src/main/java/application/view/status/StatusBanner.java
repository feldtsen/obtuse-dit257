package application.view.status;

import application.App;
import application.ResourceLoader;
import application.view.RootParent;
import application.view.navigation.ExitNavigationButton;
import application.view.util.SVGHelper;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class StatusBanner extends HBox {
    private static StatusBanner instance = null;

    private StatusBanner() {
        // Applies padding to the status banner
        this.getStyleClass().add("padding");

        // Load the logo and set the size
        Image image = new Image(ResourceLoader.logoText);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(25);

        // Toolbar button (top right of the application) for minimizing and exiting the app
        Button exit = new Button();
        Button minimize = new Button();

        // Add icons to the buttons
        exit.setGraphic(SVGHelper.createIcon(ResourceLoader.crossIcon, 0.02));
        minimize.setGraphic(SVGHelper.createIcon(ResourceLoader.minusIcon, 0.02));

        // Decide what to do when the buttons are clicked
        exit.setOnMouseClicked(e -> ExitNavigationButton.getInstance().action(e));
        minimize.setOnMouseClicked(e -> App.getStage().setIconified(true));

        // Add toolbar button for swapping the available themes
        Button colorSchemeSwap = new Button();
        colorSchemeSwap.setOnMouseClicked(e -> RootParent.getInstance().changeTheme());
        colorSchemeSwap.getStyleClass().add("colorSchemeSwap");
        // Add icon to the color swapper button
        Group sunIcon = SVGHelper.createIcon(ResourceLoader.sunIcon, 0.04);
        colorSchemeSwap.setGraphic(sunIcon);

        HBox toolbar = new HBox();
        toolbar.getChildren().addAll(
                minimize,
                exit
        );

        // Takes care of responsiveness and positioning
        HBox.setHgrow(LoginBannerModule.getInstance(), Priority.ALWAYS);
        LoginBannerModule.getInstance().setAlignment(Pos.CENTER_RIGHT);

        // Adds a styling class to the toolbar
        toolbar.getStyleClass().add("toolbar");

        // Add components in the order you want them to be displayed (left to right)
        this.getChildren().addAll(
                imageView,
                LoginBannerModule.getInstance(),
                colorSchemeSwap,
                toolbar
        );
    }

    // Singleton
    public static StatusBanner getInstance() {
        if(instance == null)
            instance = new StatusBanner();
        return instance;
    }

}
