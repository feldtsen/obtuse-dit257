package application.view.navigation;


import application.controller.BoardController;
import application.view.pages.BoardPage;
import application.view.pages.PageParent;
import javafx.scene.input.MouseEvent;

public class BoardNavigationButton extends NavigationButton {
    private static BoardNavigationButton instance = null;

    private BoardNavigationButton () {
        super();
        this.setText("Board");
        this.setOnMouseClicked(e->this.action());

    }

    public static BoardNavigationButton getInstance() {
        if (instance == null) instance = new BoardNavigationButton();
        return instance;
    }

    @Override
    public void action() {
        // Clears the posts on the board
        BoardPage.getInstance().getChildren().setAll();

        // Gets all the posts for the current client
        BoardController.retrievePosts();

        PageParent.loadPage(BoardPage.getInstance());
    }
}
