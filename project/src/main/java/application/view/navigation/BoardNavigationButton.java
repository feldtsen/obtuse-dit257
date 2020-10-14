package application.view.navigation;


import application.controller.BoardController;
import application.view.pages.PageParent;
import application.view.pages.board.BoardPage;
import javafx.scene.Group;
import javafx.scene.shape.SVGPath;

public class BoardNavigationButton extends NavigationButton {
    private static BoardNavigationButton instance = null;

    private BoardNavigationButton () {
        super();

        SVGPath svgPath = new SVGPath();
        svgPath.setContent("M296 32h192c13.255 0 24 10.745 24 24v160c0 13.255-10.745 24-24 24H296c-13.255 0-24-10.745-24-24V56c0-13.255 10.745-24 24-24zm-80 0H24C10.745 32 0 42.745 0 56v160c0 13.255 10.745 24 24 24h192c13.255 0 24-10.745 24-24V56c0-13.255-10.745-24-24-24zM0 296v160c0 13.255 10.745 24 24 24h192c13.255 0 24-10.745 24-24V296c0-13.255-10.745-24-24-24H24c-13.255 0-24 10.745-24 24zm296 184h192c13.255 0 24-10.745 24-24V296c0-13.255-10.745-24-24-24H296c-13.255 0-24 10.745-24 24v160c0 13.255 10.745 24 24 24z");
        svgPath.setScaleX(0.04);
        svgPath.setScaleY(0.04);

        Group icon = new Group(svgPath);

        this.setGraphic(icon);
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
        NavigationParent.getInstance().applyActiveClass(this);
    }
}
