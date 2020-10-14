package application.view.status;

import application.ResourceLoader;
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

        Button exit = new Button("X");
        Button minimize = new Button("-");

        HBox toolbar = new HBox();
        toolbar.getChildren().addAll(
                minimize,
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
