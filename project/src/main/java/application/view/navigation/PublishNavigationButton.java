package application.view.navigation;

import application.view.pages.PageParent;
import application.view.pages.publish.PublishPage;

public class PublishNavigationButton extends NavigationButton {
    private static PublishNavigationButton instance = null;

    private PublishNavigationButton() {
        super();
        this.setText("Publish");
        this.setOnMouseClicked(e->this.action());
    }

    public static PublishNavigationButton getInstance() {
        if (instance == null) instance = new PublishNavigationButton();
        return instance;
    }

    @Override
    public void action() {
        PageParent.loadPage(PublishPage.getInstance());
    }
}
