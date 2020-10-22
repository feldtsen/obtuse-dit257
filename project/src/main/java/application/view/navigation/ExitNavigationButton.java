package application.view.navigation;

import application.view.util.SVGHelper;
import javafx.application.Platform;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

// Button for exiting the application
public class ExitNavigationButton extends NavigationButton {
    // Singleton pattern, since there can only be one exit button
    private static ExitNavigationButton instance = null;

    private ExitNavigationButton() {
        super();

        // Set icon using SVG
        this.setGraphic(SVGHelper.createIcon("M624 448h-80V113.45C544 86.19 522.47 64 496 64H384v64h96v384h144c8.84 " +
                "0 16-7.16 16-16v-32c0-8.84-7.16-16-16-16zM312.24 1.01l-192 49.74C105.99 54.44 96 67.7 96 82.92V448H16c-8.84 " +
                "0-16 7.16-16 16v32c0 8.84 7.16 16 16 16h336V33.18c0-21.58-19.56-37.41-39.76-32.17zM264 288c-13.25 0-24-14.33-24-32s10.75-32 " +
                "24-32 24 14.33 24 32-10.75 32-24 32z", 0.05));

        // Perform action on mouse click
        this.setOnMouseClicked(this::action);

        // Set popup help text
        this.setTooltip(new Tooltip("Exit the application"));
    }

    // Create and return global instance
    public static ExitNavigationButton getInstance() {
        if (instance == null) instance = new ExitNavigationButton();
        return instance;
    }

    @Override
    public void action(MouseEvent e) {
        // Exit application
        Platform.exit();
        System.exit(0);
    }
}
