package application.view.pages.search;

import application.view.pages.Page;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class SearchBanner extends HBox implements Page {
    private final TextField searchInput;

    public SearchBanner() {
        TextField searchLabel = new TextField("Search");
        Button searchButton = new Button("Search");
        searchInput = new TextField();

        searchButton.setId("searchButton");

        this.setId("searchBanner");

        this.setId("searchModule");
        searchLabel.setId("searchLabel");

        HBox.setHgrow(searchInput, Priority.ALWAYS);

        this.getChildren().addAll(
                searchInput,
                searchButton
        );


    }
}
