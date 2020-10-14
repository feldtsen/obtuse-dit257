package application.view.pages.board;

import application.view.pages.Page;
import application.view.pages.board.filter.FilterBanner;
import application.view.pages.board.posts.PostCard;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class BoardPage extends GridPane implements Page {
    private static BoardPage instance = null;

    private BoardPage () {
        // Force the board to start at the top
        this.setAlignment(Pos.TOP_CENTER);

        //Used to make the cards the correct size
        ColumnConstraints columnConstraints = new ColumnConstraints();

        //Each cell occupies 50 percent of the width
        columnConstraints.setPercentWidth(50);

        //Defines width for the first and second column
        this.getColumnConstraints().addAll(columnConstraints, columnConstraints);

        this.setVgap(10);
        this.setHgap(10);

        this.getStyleClass().add("padding");

    }

    public static BoardPage getInstance() {
        if (instance == null) instance = new BoardPage();
        return instance;
    }

    public void setFullWidth(PostCard postCard) {
        GridPane.setColumnSpan(postCard, 2);
    }

    public void setFullWidth(FilterBanner filterBanner) {
        GridPane.setColumnSpan(filterBanner, 2);
    }

}
