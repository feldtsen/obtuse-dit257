package application.view.pages;

import application.controller.BoardController;
import application.view.pages.login.LoginStatusModule;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class PageParent extends ScrollPane {
    private static PageParent instance = null;

    private PageParent() {
        this.setId("pageParent");

        // Pages min width and min height is as big as the scroll pane
        this.fitToWidthProperty().set(true);
        //this.fitToHeightProperty().set(true);

        // Add pages to the scroll pane
        // The one set here will be the initial page
        this.setContent(BoardPage.getInstance());
        BoardController.retrievePosts();
    }

    // Singleton
    public static PageParent getInstance() {
        if (instance == null) instance = new PageParent();
        return instance;
    }

    // Changes the active page
    public static void loadPage (Node page) {
        instance.setContent(page);

    }

}
