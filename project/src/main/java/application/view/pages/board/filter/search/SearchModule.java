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
    private String storedString;

    public SearchModule() {
        ComboBoxListViewSkin<String> tagDropdownSkin = new ComboBoxListViewSkin<>(tagDropdown);
        tagDropdownSkin.getPopupContent().addEventFilter(KeyEvent.ANY, (event) -> {
            if( event.getCode() == KeyCode.SPACE || event.getCode()== KeyCode.ESCAPE) {
                event.consume();
            }
        });

        tagDropdown.setSkin(tagDropdownSkin);

        Button searchButton = new Button();

        searchButton.setGraphic(SVGHelper.createIcon(ResourceLoader.magnifierIcon, 0.02));
        searchButton.getStyleClass().add("magnifierIcon");

        searchButton.setOnMouseClicked( e -> {
            System.out.println(storedString);
            onSearchButton();
        });

        searchInput.setPromptText("search");
        searchInput.setOnKeyReleased(e -> this.keyTyped(e.getCode()));
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

    private void keyTyped(KeyCode keyCode) {

        if(searchInput.getText() == null) {
            tagDropdown.hide();
            return;
        }

        storedString = searchInput.getText();

        if(storedString.equals("")) {
            BoardController.setFilter(new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), Set.of()));
            return;
        }

        if (keyCode.equals(KeyCode.ENTER)){
            tagDropdown.hide();
            IFilter f1 = new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), Set.of(storedString));
            BoardController.setFilter(new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), f1.getTags()));
            searchInput.selectEnd();
            return;
        }

        tagDropdown.filter(storedString);

        tagDropdown.show();
    }

    public void onSearchButton() {
        BoardController.setFilter(new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), Set.of(storedString)));
        tagDropdown.filter(storedString);
        searchInput.setText(storedString);
    }

    public String getStoredString() {
        return storedString;
    }
}
