package application.view.pages.board.filter;

import application.view.pages.board.filter.categories.CategoryButtonContainer;
import application.view.pages.board.filter.search.SearchModule;
import javafx.scene.layout.HBox;

public class FilterBanner extends HBox {
    public FilterBanner (){
        SearchModule searchModule = new SearchModule();
        CategoryButtonContainer categoryButtonContainer = new CategoryButtonContainer();

        this.getChildren().addAll(
                categoryButtonContainer,
                searchModule
        );
    }
}
