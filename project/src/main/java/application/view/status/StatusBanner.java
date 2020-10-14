package application.view.status;

import application.ResourceLoader;
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
        imageView.setFitHeight(34);

        this.getChildren().addAll(
                imageView,
                AlertBannerModule.getInstance(),
                LoginBannerModule.getInstance()
        );
    }

    public static StatusBanner getInstance() {
        if(instance == null)
            instance = new StatusBanner();
        return instance;
    }

}
