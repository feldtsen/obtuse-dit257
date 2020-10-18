package application.view.pages.board.filter.search;

import application.ResourceLoader;
import application.controller.BoardController;
import application.model.board.Filter;
import application.model.board.IFilter;
import application.view.pages.board.filter.categories.CategoryButtonContainer;
import application.view.util.SVGHelper;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.Set;

public class SearchModule extends GridPane {
    private final TagDropdown tagDropdown = new TagDropdown();
    private final TextField searchInput = new TextField();

    public SearchModule() {
        ComboBoxListViewSkin<String> tagDropdownSkin = new ComboBoxListViewSkin<>(tagDropdown);
        tagDropdownSkin.getPopupContent().addEventFilter(KeyEvent.ANY, (event) -> {
            if( event.getCode() == KeyCode.SPACE || event.getCode()== KeyCode.ESCAPE ) {
                event.consume();
            }
        });
        tagDropdown.setSkin(tagDropdownSkin);


        Button searchButton = new Button();

        searchButton.setGraphic(SVGHelper.createIcon(ResourceLoader.magnifierIcon, 0.02));
        searchButton.getStyleClass().add("magnifierIcon");



        searchButton.setOnMouseClicked( e -> tagDropdown.filter(searchInput.getText()));


        searchInput.setPromptText("search");
        searchInput.setOnKeyReleased(this::keyTyped);
        GridPane.setFillWidth(searchInput,  true);
        GridPane.setHgrow(searchInput,  Priority.ALWAYS);
        HBox.setHgrow(this, Priority.ALWAYS);


        tagDropdown.setOnHiding(e -> searchInput.setText(tagDropdown.getSelectionModel().getSelectedItem()));
        tagDropdown.getStyleClass().add("tagDropdown");
        tagDropdown.setMaxWidth(10000000000d);



        this.setHgap(5);



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
