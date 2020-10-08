package application.view.pages.board;

import application.view.pages.Page;
import application.view.pages.board.posts.PostCard;
import application.view.pages.board.search.SearchModule;
import javafx.scene.layout.*;

public class BoardPage extends GridPane implements Page {
    private static BoardPage instance = null;

    private BoardPage () {
        // Id used for styling
        this.setId("boardPage");

        //Used to make the cards the correct size
        ColumnConstraints columnConstraints = new ColumnConstraints();

        //Each cell occupies 50 percent of the width
        columnConstraints.setPercentWidth(50);

        //Defines width for the first and second column
        this.getColumnConstraints().addAll(columnConstraints, columnConstraints);

        this.setVgap(10);
        this.setHgap(10);
    }

    public static BoardPage getInstance() {
        if (instance == null) instance = new BoardPage();
        return instance;
    }

    public void setFullWidth(PostCard postCard) {
        GridPane.setColumnSpan(postCard, 2);
    }

    public void setFullWidth(SearchModule searchModule) {
        GridPane.setColumnSpan(searchModule, 2);
    }
}
