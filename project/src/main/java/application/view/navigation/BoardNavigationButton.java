package application.view.navigation;


import application.controller.BoardController;
import application.view.pages.PageParent;
import application.view.pages.board.BoardPage;

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
        // Gets all the posts for the current client
        BoardController.retrievePosts();

        PageParent.loadPage(BoardPage.getInstance());
    }
}
