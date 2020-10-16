package application.view.pages;

import application.view.navigation.LoginNavigationButton;
import application.view.navigation.NavigationParent;
import application.view.pages.login.RegisterPage;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

public class PageParent extends HBox {
    private static PageParent instance = null;
    private static final VBox pageContainer = new VBox();

    private PageParent() {
        ScrollPane content = new ScrollPane();

        Region margin = new Region();
        Region margin2 = new Region();

        HBox.setHgrow(margin, Priority.ALWAYS);
        HBox.setHgrow(margin2, Priority.ALWAYS);

        HBox.setHgrow(this, Priority.ALWAYS);
        HBox.setHgrow(pageContainer, Priority.ALWAYS);
        HBox.setHgrow(content, Priority.ALWAYS);

        content.setId("pageParent");
        pageContainer.setId("maxWidth");


        // Pages min width and min height is as big as the scroll pane
        content.fitToWidthProperty().set(true);

        content.setContent(
                pageContainer
        );

        this.getChildren().addAll(margin, content, margin2);

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
