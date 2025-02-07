package application.view.navigation;

import application.view.pages.PageParent;
import application.view.pages.publish.PublishPage;
import application.view.util.SVGHelper;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

// Navigation button for entering the publish page/view
public class PublishNavigationButton extends NavigationButton {
    // Singleton pattern
    private static PublishNavigationButton instance = null;

    private PublishNavigationButton() {
        super();

        // Set icon using SVG
        this.setGraphic(SVGHelper.createIcon("M402.6 83.2l90.2 90.2c3.8 3.8 3.8 10 0 13.8L274.4 " +
                "405.6l-92.8 10.3c-12.4 1.4-22.9-9.1-21.5-21.5l10.3-92.8L388.8 83.2c3.8-3.8 10-3.8 13.8 " +
                "0zm162-22.9l-48.8-48.8c-15.2-15.2-39.9-15.2-55.2 0l-35.4 35.4c-3.8 3.8-3.8 10 0 13.8l90.2 90.2c3.8 3.8 " +
                "10 3.8 13.8 0l35.4-35.4c15.2-15.3 15.2-40 0-55.2zM384 346.2V448H64V128h229.8c3.2 0 6.2-1.3 " +
                "8.5-3.5l40-40c7.6-7.6 2.2-20.5-8.5-20.5H48C21.5 64 0 85.5 0 112v352c0 26.5 21.5 48 48 48h352c26.5 0 " +
                "48-21.5 48-48V306.2c0-10.7-12.9-16-20.5-8.5l-40 40c-2.2 2.3-3.5 5.3-3.5 8.5z", 0.05));

        // Perform action on mouse press
        this.setOnMouseClicked(this::action);

        // Set help popup text
        this.setTooltip(new Tooltip("Here you can publish posts"));
    }

    // Create and return global instance
    public static PublishNavigationButton getInstance() {
        if (instance == null) instance = new PublishNavigationButton();
        return instance;
    }

    @Override
    public void action(MouseEvent e) {
        // Unset the file selected by the image chooser (WHY?)
        // TODO START move this?
        PublishPage.getInstance().getMetaModule().getImageChooser().setSelectedFile(null);
        PublishPage.getInstance().getMetaModule().getImageChooser().setRelativePath("");
        // TODO END

        // Load the publish page
        PageParent.loadPage(PublishPage.getInstance(), this);
    }
}
