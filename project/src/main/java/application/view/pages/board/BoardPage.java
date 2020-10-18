package application.view.pages.board;

import application.view.pages.Page;
import application.view.pages.board.filter.FilterBanner;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class BoardPage extends GridPane implements Page {
    private static BoardPage instance = null;

    private BoardPage () {
        // Force the board to start at the top
        this.setAlignment(Pos.TOP_CENTER);

        this.setVgap(10);
        this.setHgap(10);

        this.getStyleClass().add("padding");


        ColumnConstraints col = new ColumnConstraints(300);
        this.getColumnConstraints().addAll(col,col,col);
    }

    public static BoardPage getInstance() {
        if (instance == null) instance = new BoardPage();
        return instance;
    }

    public void setFullWidth(FilterBanner filterBanner) {
        GridPane.setColumnSpan(filterBanner, 3);
    }

}
