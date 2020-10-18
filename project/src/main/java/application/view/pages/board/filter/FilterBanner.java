package application.view.pages.board.filter;

import application.view.pages.board.filter.categories.CategoryButtonContainer;
import application.view.pages.board.filter.search.SearchModule;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class FilterBanner extends HBox {
    private static FilterBanner instance = null;
    private FilterBanner (){
        SearchModule searchModule = new SearchModule();
        CategoryButtonContainer categoryButtonContainer = new CategoryButtonContainer();




        this.getStyleClass().add("spacing");
        this.getChildren().setAll(categoryButtonContainer, searchModule);

        HBox.setHgrow(this, Priority.ALWAYS);
        GridPane.setHgrow(this, Priority.ALWAYS);

    }
    public static FilterBanner getInstance() {
        if (instance == null) instance = new FilterBanner();
        return instance;
    }
}
