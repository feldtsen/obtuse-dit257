package application.view.pages.board.filter;

import application.view.pages.board.filter.categories.CategoryButtonContainer;
import application.view.pages.board.filter.search.SearchModule;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

// The filter banner is a module for the search bar and the category button container
// Together, they define the UI elements used by the user to filter the contents of the board
// to their liking.
public class FilterBanner extends HBox {
    // Singleton pattern is used since there should only be one filter banner
    private static FilterBanner instance = null;

    private FilterBanner (){
        // Create search module
        SearchModule searchModule = new SearchModule();

        // Create category button container
        CategoryButtonContainer categoryButtonContainer = new CategoryButtonContainer();

        // Define styles
        this.getStyleClass().add("spacing");

        HBox.setHgrow(this, Priority.ALWAYS);
        GridPane.setHgrow(this, Priority.ALWAYS);

        this.getChildren().setAll(categoryButtonContainer, searchModule);
    }

    // Create and return global instance
    public static FilterBanner getInstance() {
        if (instance == null) instance = new FilterBanner();
        return instance;
    }
}
