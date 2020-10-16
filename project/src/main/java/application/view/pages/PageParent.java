package application.view.pages;

import application.view.navigation.RegisterNavigationButton;
import application.view.navigation.NavigationButton;
import application.view.navigation.NavigationParent;
import application.view.pages.login.RegisterPage;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

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

        loadPage(RegisterPage.getInstance(), RegisterNavigationButton.getInstance());

    }

    // Singleton
    public static PageParent getInstance() {
        if (instance == null) instance = new PageParent();
        return instance;
    }

    // Changes the active page
    public static void loadPage (Node page, NavigationButton button) {
        NavigationParent.getInstance().applyActiveClass(button);
        pageContainer.getChildren().setAll(
                page
        );
    }

}
