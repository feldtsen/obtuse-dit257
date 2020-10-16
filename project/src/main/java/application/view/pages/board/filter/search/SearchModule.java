package application.view.pages.board.filter.search;

import application.controller.BoardController;
import application.model.board.Filter;
import application.model.board.IFilter;
import application.view.pages.board.filter.categories.CategoryButtonContainer;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.shape.SVGPath;

import java.util.Set;

public class SearchModule extends GridPane {
    private final TagDropdown tagDropdown = new TagDropdown();
    private final SearchInput searchInput = new SearchInput();

    public SearchModule() {
        ComboBoxListViewSkin<String> tagDropdownSkin = new ComboBoxListViewSkin<>(tagDropdown);
        tagDropdownSkin.getPopupContent().addEventFilter(KeyEvent.ANY, (event) -> {
            if( event.getCode() == KeyCode.SPACE || event.getCode()== KeyCode.ESCAPE) {
                event.consume();
            }
        });
        tagDropdown.setSkin(tagDropdownSkin);


        Button searchButton = new Button();
        SVGPath svgPath = new SVGPath();
        svgPath.setContent("M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z");
        svgPath.setScaleX(0.02);
        svgPath.setScaleY(0.02);

        Group icon = new Group(svgPath);
        searchButton.setGraphic(icon);
        searchButton.getStyleClass().add("search");


        searchButton.setOnMouseClicked( e -> tagDropdown.filter(searchInput.getText()));


        searchInput.setPromptText("search");
        searchInput.setOnKeyReleased(this::keyTyped);


        tagDropdown.setOnHiding(e -> searchInput.setText(tagDropdown.getSelectionModel().getSelectedItem()));
        tagDropdown.getStyleClass().add("tagDropdown");


        HBox.setHgrow(this, Priority.ALWAYS);

        this.setHgap(10);


        GridPane.setHgrow(searchInput, Priority.ALWAYS);
        GridPane.setHgrow(tagDropdown, Priority.ALWAYS);

        this.add(tagDropdown, 0, 0);
        this.add(searchInput, 0, 0);
        this.add(searchButton, 1, 0);
    }

    private void keyTyped(KeyEvent keyEvent) {

        KeyCode keyCode = keyEvent.getCode();

        if(searchInput.getText() == null) {
            tagDropdown.hide();
            return;
        }

        if(searchInput.getText().equals("")) {
            BoardController.setFilter(new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), Set.of()));
            return;
        }

        if (keyCode.equals(KeyCode.ENTER)){
            tagDropdown.hide();
            IFilter f1 = new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), Set.of(searchInput.getText()));
            BoardController.setFilter(new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), f1.getTags()));
            searchInput.selectEnd();
            return;
        }

        tagDropdown.filter(searchInput.getText());

        tagDropdown.show();
    }
}
