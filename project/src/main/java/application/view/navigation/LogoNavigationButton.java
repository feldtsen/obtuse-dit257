package application.view.navigation;


import application.ResourceLoader;
import application.view.pages.board.BoardPage;
import application.view.pages.PageParent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LogoNavigationButton extends NavigationButton {
    private static LogoNavigationButton instance = null;

    private LogoNavigationButton() {
        super();
        this.setId("logoButton");

        Image image = new Image(ResourceLoader.logo);
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

        this.setGraphic(imageView);


        this.setOnMouseClicked(e-> this.action());
    }

    public static LogoNavigationButton getInstance() {
        if (instance == null) instance = new LogoNavigationButton();
        return instance;
    }

    @Override
    public void action() {
        PageParent.loadPage(BoardPage.getInstance());
    }
}
