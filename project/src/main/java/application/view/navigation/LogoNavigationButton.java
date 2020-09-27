package application.view.navigation;


import application.view.ResourceLoader;
import application.view.pages.BoardPage;
import application.view.pages.PageParent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LogoNavigationButton extends NavigationButton {
    private static LogoNavigationButton instance = null;

    private LogoNavigationButton() {
        super();
        this.setId("logoButton");

        Image image = new Image(ResourceLoader.logo);
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(80);
        imageView.setPreserveRatio(true);

        this.setGraphic(imageView);


        this.setOnMouseClicked(this::action);
    }

    public static LogoNavigationButton getInstance() {
        if (instance == null) instance = new LogoNavigationButton();
        return instance;
    }

    @Override
    public void action(MouseEvent e) {
        PageParent.loadPage(BoardPage.getInstance());
    }
}
