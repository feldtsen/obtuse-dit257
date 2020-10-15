package application.view.pages;

import application.view.navigation.LoginNavigationButton;
import application.view.navigation.NavigationParent;
import application.view.pages.login.RegisterPage;
import application.view.status.StatusBanner;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class PageParent extends ScrollPane {
    private static PageParent instance = null;
    private static final VBox pageContainer = new VBox();

    private PageParent() {
        this.setId("pageParent");


        // Pages min width and min height is as big as the scroll pane
        this.fitToWidthProperty().set(true);
        //this.fitToHeightProperty().set(true);

        // Add pages to the scroll pane
        // The one set here will be the initial page.setContent(RegisterPage.getInstance());
        this.setContent(
                pageContainer
        );
        loadPage(RegisterPage.getInstance());
        NavigationParent.getInstance().applyActiveClass(LoginNavigationButton.getInstance());
    }

    // Singleton
    public static PageParent getInstance() {
        if (instance == null) instance = new PageParent();
        return instance;
    }

    // Changes the active page
    public static void loadPage (Node page) {
        pageContainer.getChildren().setAll(
                page
        );
    }

}
