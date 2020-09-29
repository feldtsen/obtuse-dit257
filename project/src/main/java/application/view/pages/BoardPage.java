package application.view.pages;

import application.controller.BoardController;
import javafx.scene.layout.VBox;

public class BoardPage extends VBox implements Page {
    private static BoardPage instance = null;

    private BoardPage () {
        this.setId("boardPage");


    }

    public static BoardPage getInstance() {
        if (instance == null) instance = new BoardPage();

        return instance;
    }
}
