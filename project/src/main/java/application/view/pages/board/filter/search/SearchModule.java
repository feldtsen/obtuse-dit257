package application.view.pages.board.filter.search;

import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.shape.SVGPath;

public class SearchModule extends GridPane {
    public SearchModule() {
        TagDropdown tagDropdown = new TagDropdown();



        Button searchButton = new Button();
        SVGPath svgPath = new SVGPath();
        svgPath.setContent("M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z");
        svgPath.setScaleX(0.02);
        svgPath.setScaleY(0.02);

        Group icon = new Group(svgPath);
        searchButton.setGraphic(icon);
        searchButton.getStyleClass().add("search");


        searchButton.setOnMouseClicked( e -> {
            tagDropdown.filter(tagDropdown.getSearchInputField().getText());
        });



        HBox.setHgrow(this, Priority.ALWAYS);
        this.setHgap(10);


        tagDropdown.prefWidthProperty().bind(this.widthProperty());
        tagDropdown.getSearchInputField().prefWidthProperty().bind(this.widthProperty());

        searchButton.prefHeightProperty().bind(this.heightProperty());

        GridPane.setHalignment(searchButton, HPos.RIGHT);

        this.add(tagDropdown, 0, 0);
        this.add(tagDropdown.getSearchInputField(), 0, 0);
        this.add(searchButton, 1, 0);
    }
}
