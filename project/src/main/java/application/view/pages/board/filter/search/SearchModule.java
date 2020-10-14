package application.view.pages.board.filter.search;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class SearchModule extends GridPane {
    public SearchModule() {
        TagDropdown tagDropdown = new TagDropdown();
        Button searchButton = new Button("Search");

        HBox.setHgrow(this, Priority.ALWAYS);


        tagDropdown.prefWidthProperty().bind(this.widthProperty());
        tagDropdown.getSearchInputField().prefWidthProperty().bind(this.widthProperty());

        searchButton.prefWidthProperty().bind(this.widthProperty().multiply(.1));

        searchButton.prefHeightProperty().bind(this.heightProperty());

        GridPane.setHalignment(searchButton, HPos.RIGHT);

        this.getChildren().addAll(
                tagDropdown,
                tagDropdown.getSearchInputField(),
                searchButton
        );
    }
}
