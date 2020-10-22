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

// Module defining a search bar where the user can input keywords (tags) to search from.
// When the user uses the search bar, a filter is created which modifies the visible contents
// of the board view.
public class SearchModule extends GridPane {
    // Tag drop down, where the user can view the searchable options
    private final TagDropdown tagDropdown = new TagDropdown();

    // Search input field. This is where the user inputs data.
    private final TextField searchInput = new TextField();

    // The search word entered by the user
    private String input;

    public SearchModule() {
        // Create a "skin" for the tag drop down
        ComboBoxListViewSkin<String> tagDropdownSkin = new ComboBoxListViewSkin<>(tagDropdown);

        // Filter out key events from the tag drop down view.
        tagDropdownSkin.getPopupContent().addEventFilter(KeyEvent.ANY, (event) -> {
            if( event.getCode() == KeyCode.SPACE || event.getCode()== KeyCode.ESCAPE) {
                event.consume();
            }
        });

        // Set the skin of the tag drop down to the newly created one
        tagDropdown.setSkin(tagDropdownSkin);

        // Create search button which can be used to apply the entered keyword
        Button searchButton = new Button();

        // Set the icon of the search button using SVG
        searchButton.setGraphic(SVGHelper.createIcon(ResourceLoader.magnifierIcon, 0.02));
        // Set style
        searchButton.getStyleClass().add("magnifierIcon");

        // Define action to be performed on search button press
        searchButton.setOnMouseClicked( e -> {
            onSearchButton();
        });

        // Set prompt
        searchInput.setPromptText("search");

        // Reda keyboard input and define different actions depending on the keycode
        searchInput.setOnKeyReleased(e -> this.keyTyped(e.getCode()));

        // Set dimensions of the search bar
        GridPane.setFillWidth(searchInput,  true);
        GridPane.setHgrow(searchInput,  Priority.ALWAYS);
        HBox.setHgrow(this, Priority.ALWAYS);

        // Define styling of tag dropdown
        tagDropdown.setOnHiding(e -> searchInput.setText(tagDropdown.getSelectionModel().getSelectedItem()));
        tagDropdown.getStyleClass().add("tagDropdown");
        tagDropdown.setMaxWidth(10000000000d);

        // Set style and layout for entire module
        this.setHgap(5);

        this.add(tagDropdown, 0, 0);
        this.add(searchInput, 0, 0);
        this.add(searchButton, 1, 0);
    }

    // On key typed, different actions are executed depending on keycode.
    private void keyTyped(KeyCode keyCode) {
        // If no text has been entered, hide the tag dropdown
        if(searchInput.getText() == null) {
            tagDropdown.hide();
            return;
        }

        // Fetch the entered text
        input = searchInput.getText();

        // If the string is empty, set the board filter tags to a filter with no tags
        if(input.equals("")) {
            // Use the same category specified by the category button container
            BoardController.setFilter(new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), Set.of()));
            return;
        }

        // If the enter key is pressed...
        if (keyCode.equals(KeyCode.ENTER)){
            // Hide the tag dropdown
            tagDropdown.hide();

            // Create a new filter with the input as a tag used for filtering
            BoardController.setFilter(new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), Set.of(input)));

            searchInput.selectEnd();
            return;
        }

        // Filter the tags depending on the input. This ensures only the tags matching the input text shows up
        // in the drop down
        tagDropdown.filter(input);

        tagDropdown.show();
    }

    // On search button press...
    public void onSearchButton() {
        // Apply filter
        BoardController.setFilter(new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), Set.of(input)));

        // Filter tag drop down
        tagDropdown.filter(input);

        // Set text of search bar
        searchInput.setText(input);
    }

    public String getInput() {
        return input;
    }
}
