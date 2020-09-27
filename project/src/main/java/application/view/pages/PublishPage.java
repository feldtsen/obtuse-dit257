package application.view.pages;

import javafx.scene.layout.VBox;

public class PublishPage extends VBox implements Page {
    private static PublishPage instance = null;

    private PublishPage() {
        this.setId("publishPage");
    }

    public static PublishPage getInstance() {
        if (instance == null) instance = new PublishPage();
        return instance;
    }
}
