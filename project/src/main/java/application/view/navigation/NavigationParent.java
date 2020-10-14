package application.view.navigation;

import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class NavigationParent extends VBox {
    private static NavigationParent instance = null;

    private NavigationParent() {
        // Id given to reference it in a css file
        this.setId("navigationParent");
        Region spacing = new Region();
        Region spacing2 = new Region();
        spacing.minHeightProperty().bind(this.heightProperty().multiply(.2));
        spacing2.minHeightProperty().bind(this.heightProperty().multiply(.2));

        // Add navigation buttons here
        this.getChildren().addAll(
                spacing,
                BoardNavigationButton.getInstance(),
                PublishNavigationButton.getInstance(),
                LoginNavigationButton.getInstance(),
                ExitNavigationButton.getInstance(),
                spacing2
        );

    }

    // Singleton
    public static NavigationParent getInstance() {
        if (instance == null) {
            instance = new NavigationParent();
        }

        return instance;
    }

    public void applyActiveClass(Node activeNode){
        for (Node node : this.getChildren()){
           node.getStyleClass().remove("activeNavigation");
        }

        activeNode.getStyleClass().add("activeNavigation");
    }

}
