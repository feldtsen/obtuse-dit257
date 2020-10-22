package application.view.navigation;

import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

// Navigation panel which contains all navigation buttons
// This is a holder class for all buttons used to change page/view.
public class NavigationParent extends VBox {
    // Singleton pattern implemented since there can only be one
    private static NavigationParent instance = null;

    private NavigationParent() {
        // Id given to reference it in a css file
        this.setId("navigationParent");

        // Set spacing
        Region upperSpacing = new Region();
        Region lowerSpacing = new Region();
        upperSpacing.minHeightProperty().bind(this.heightProperty().multiply(.2));
        lowerSpacing.minHeightProperty().bind(this.heightProperty().multiply(.2));

        // Add navigation buttons here
        this.getChildren().addAll(
                upperSpacing,
                BoardNavigationButton.getInstance(),
                PublishNavigationButton.getInstance(),
                RegisterNavigationButton.getInstance(),
                ExitNavigationButton.getInstance(),
                lowerSpacing
        );

    }

    // Create and return global instance
    public static NavigationParent getInstance() {
        if (instance == null) {
            instance = new NavigationParent();
        }

        return instance;
    }

    // Remove active navigation status from all other currently active navigation buttons,
    // and then set the current active node style to active.
    public void applyActiveClass(Node activeNode){
        for (Node node : this.getChildren()){
           node.getStyleClass().remove("activeNavigation");
        }

        activeNode.getStyleClass().add("activeNavigation");
    }

}
