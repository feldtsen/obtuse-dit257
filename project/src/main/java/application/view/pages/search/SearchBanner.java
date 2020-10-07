package application.view.pages.search;

import application.view.pages.Page;
import application.view.pages.board.posts.TagDropdown;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class SearchBanner extends HBox implements Page {

    public SearchBanner() {
        Button searchButton = new Button("Search");

        searchButton.setId("searchButton");

        this.setId("searchBanner");

        this.setId("searchModule");


        this.getChildren().addAll(
                new SearchInput(),
                TagDropdown.getInstance(),
                searchButton
        );
    }

}
