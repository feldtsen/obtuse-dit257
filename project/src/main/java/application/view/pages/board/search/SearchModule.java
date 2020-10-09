package application.view.pages.board.search;

import application.view.pages.board.BoardPage;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class SearchModule extends GridPane {
    public SearchModule() {
        TagDropdown tagDropdown = new TagDropdown();
        Button searchButton = new Button("Search");


        this.prefWidthProperty().bind(BoardPage.getInstance().widthProperty());

        tagDropdown.prefWidthProperty().bind(this.widthProperty());
        tagDropdown.getSearchInputField().prefWidthProperty().bind(this.widthProperty());

        searchButton.prefWidthProperty().bind(this.widthProperty().multiply(.1));
        searchButton.setId("searchButton");

        GridPane.setHalignment(searchButton, HPos.RIGHT);

        this.getChildren().addAll(
                tagDropdown,
                tagDropdown.getSearchInputField(),
                searchButton
        );
    }
}
