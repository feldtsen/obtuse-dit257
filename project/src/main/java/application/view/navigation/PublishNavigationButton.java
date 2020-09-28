package application.view.navigation;

import application.view.pages.PageParent;
import application.view.pages.PublishPage;
import javafx.scene.input.MouseEvent;

public class PublishNavigationButton extends NavigationButton {
    private static PublishNavigationButton instance = null;

    private PublishNavigationButton() {
        super();
        this.setText("Publish");
        this.setOnMouseClicked(this::action);

    }

    public static PublishNavigationButton getInstance() {
        if (instance == null) instance = new PublishNavigationButton();
        return instance;
    }

    @Override
    public void action(MouseEvent e) {
        PageParent.loadPage(PublishPage.getInstance());
    }
}
