package application.view.pages;

import javafx.scene.control.ScrollPane;

public class PageParent extends ScrollPane {
    private static PageParent instance = null;

    private PageParent() {
        this.setId("contentParent");

    }

    public static PageParent getInstance() {
        if (instance == null) instance = new PageParent();
        return instance;
    }

}
