package application.view.navigation;


import application.controller.BoardController;
import application.view.pages.PageParent;
import application.view.pages.board.BoardPage;
import application.view.util.SVGHelper;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

// Navigation button for entering the board view
public class BoardNavigationButton extends NavigationButton {
    // Singleton pattern is implemented since there can only be one board button
    private static BoardNavigationButton instance = null;

    private BoardNavigationButton () {
        super();

        // Load icon using SVG
        this.setGraphic(SVGHelper.createIcon("M296 32h192c13.255 0 24 10.745 24 24v160c0 13.255-10.745 24-24 " +
                "24H296c-13.255 0-24-10.745-24-24V56c0-13.255 10.745-24 24-24zm-80 0H24C10.745 32 0 42.745 0 56v160c0 " +
                "13.255 10.745 24 24 24h192c13.255 0 24-10.745 24-24V56c0-13.255-10.745-24-24-24zM0 296v160c0 13.255 " +
                "10.745 24 24 24h192c13.255 0 24-10.745 24-24V296c0-13.255-10.745-24-24-24H24c-13.255 0-24 10.745-24 " +
                "24zm296 184h192c13.255 0 24-10.745 24-24V296c0-13.255-10.745-24-24-24H296c-13.255 0-24 10.745-24 " +
                "24v160c0 13.255 10.745 24 24 24z", 0.05));

        // Perform action on mouse click
        this.setOnMouseClicked(this::action);

        // Set popup help text
        this.setTooltip(new Tooltip("Takes you to all the published posts"));

    }

    // Create and return global instance
    public static BoardNavigationButton getInstance() {
        if (instance == null) instance = new BoardNavigationButton();
        return instance;
    }

    @Override
    public void action(MouseEvent e) {
        // Gets all the posts for the current client
        BoardController.retrievePosts();

        // Change active page to the board page
        PageParent.loadPage(BoardPage.getInstance(), this);
    }
}
