package application.view.pages.search;

import application.view.pages.Page;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SearchBanner extends HBox implements Page {
    private static SearchBanner instance = null;

    private final TextField searchInput;

    public SearchBanner() {
        TextField searchLabel = new TextField("Search");
        Button searchButton = new Button("Search");
        searchInput = new TextField();

        this.setId("searchModule");
        searchLabel.setId("searchLabel");

        this.getChildren().addAll(
                searchInput,
                searchButton
        );


    }
}
