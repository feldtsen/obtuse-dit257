package application.view.navigation;


import application.view.pages.BoardPage;
import application.view.pages.PageParent;

public class BoardNavigationButton extends NavigationButton {
    private static BoardNavigationButton instance = null;

    private BoardNavigationButton () {
        super();
        this.setText("Board");
        this.setOnMouseClicked(e -> this.action());

    }

    public static BoardNavigationButton getInstance() {
        if (instance == null) instance = new BoardNavigationButton();
        return instance;
    }

    @Override
    public void action() {
        PageParent.loadPage(BoardPage.getInstance());
    }
}
