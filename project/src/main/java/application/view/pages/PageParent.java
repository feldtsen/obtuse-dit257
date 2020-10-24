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
    private static final VBox pageContentContainer = new VBox();

    private PageParent() {
        // Scrollable content
        ScrollPane scrollableContentContainer = new ScrollPane();

        // We want to maximize the width of the content, when this limit is reached we add margins to center the content
        Region leftMargin = new Region();
        Region rightMargin = new Region();
        HBox.setHgrow(leftMargin, Priority.ALWAYS);
        HBox.setHgrow(rightMargin, Priority.ALWAYS);

        HBox.setHgrow(this, Priority.ALWAYS);
        HBox.setHgrow(pageContentContainer, Priority.ALWAYS);
        HBox.setHgrow(scrollableContentContainer, Priority.ALWAYS);

        scrollableContentContainer.setId("pageParent");
        pageContentContainer.setId("maxWidth");


        // Make the scrollable content occupy the width given to it
        scrollableContentContainer.fitToWidthProperty().set(true);

        // Take in a VBox that expands vertically, resolving in a vertical scrollbar when container is filled
        scrollableContentContainer.setContent(
                pageContentContainer
        );

        this.getChildren().addAll(leftMargin, scrollableContentContainer, rightMargin);

        // The default page we want to show the user when the application launches
        loadPage(RegisterPage.getInstance(), RegisterNavigationButton.getInstance());
    }

    // Singleton
    public static PageParent getInstance() {
        if (instance == null) instance = new PageParent();
        return instance;
    }

    // Changes the active page and highlight the respective navigation button in green
    public static void loadPage (Node page, NavigationButton button) {
        NavigationParent.getInstance().applyActiveClass(button);
        HBox.setHgrow(page, Priority.ALWAYS);
        pageContentContainer.getChildren().setAll(
                page
        );
    }

}
