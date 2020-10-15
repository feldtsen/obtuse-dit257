package application.view.status;

import application.App;
import application.ResourceLoader;
import application.view.navigation.ExitNavigationButton;
import application.view.util.SVGHelper;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class StatusBanner extends HBox {
    private static StatusBanner instance = null;

    private StatusBanner() {
        this.getStyleClass().add("padding");

        Image image = new Image(ResourceLoader.logoText);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(25);

        Button exit = new Button();
        Button minimize = new Button();
        //Button maximize = new Button();
        exit.setGraphic(SVGHelper.createIcon("M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z", 0.02));
        //maximize.setGraphic(SVGHelper.createIcon("M464 32H48C21.5 32 0 53.5 0 80v352c0 26.5 21.5 48 48 48h416c26.5 0 48-21.5 48-48V80c0-26.5-21.5-48-48-48zm-16 160H64v-84c0-6.6 5.4-12 12-12h360c6.6 0 12 5.4 12 12v84z", 0.02));
        minimize.setGraphic(SVGHelper.createIcon("M464 352H48c-26.5 0-48 21.5-48 48v32c0 26.5 21.5 48 48 48h416c26.5 0 48-21.5 48-48v-32c0-26.5-21.5-48-48-48z", 0.02));

        exit.setOnMouseClicked(e -> ExitNavigationButton.getInstance().action());
        minimize.setOnMouseClicked(e -> App.getStage().setIconified(true));



        HBox toolbar = new HBox();
        toolbar.getChildren().addAll(
                minimize,
         //       maximize,
                exit
        );

        toolbar.getStyleClass().add("toolbar");

        this.getChildren().addAll(
                imageView,
                AlertBannerModule.getInstance(),
                LoginBannerModule.getInstance(),
                toolbar
        );
    }

    public static StatusBanner getInstance() {
        if(instance == null)
            instance = new StatusBanner();
        return instance;
    }

}
