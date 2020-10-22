package application.view.pages.board;

import application.view.pages.Page;
import application.view.pages.board.filter.FilterBanner;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

// A page which displays the contents of the board
public class BoardPage extends GridPane implements Page {
    // Singleton pattern since there should only be one board page
    private static BoardPage instance = null;

    private BoardPage () {
        // Force the board to start at the top
        this.setAlignment(Pos.TOP_CENTER);

        // Set styling
        this.setVgap(10);
        this.setHgap(10);

        this.getStyleClass().add("padding");

        ColumnConstraints col = new ColumnConstraints(280);
        this.getColumnConstraints().addAll(col,col,col);
    }

    // Create and return global instance
    public static BoardPage getInstance() {
        if (instance == null) instance = new BoardPage();
        return instance;
    }

    // Set full width of the board page
    public void setFullWidth(FilterBanner filterBanner) {
        GridPane.setColumnSpan(filterBanner, 3);
    }
}
