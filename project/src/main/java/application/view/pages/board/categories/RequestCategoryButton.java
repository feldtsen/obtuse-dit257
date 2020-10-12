package application.view.pages.board.categories;

import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;

public class RequestCategoryButton extends Button implements OnClickAction {
    private static RequestCategoryButton instance = null;

    private RequestCategoryButton() {
        this.setText("Requests");
        this.setOnMouseClicked(e -> this.action());
        this.setId("inactive");
    }

    public static RequestCategoryButton getInstance() {
        if (instance == null) instance = new RequestCategoryButton();
        return instance;
    }

    private void toggleActiveStatus() {
        if (this.getId().equals("inactive"))
            this.setId("active");
        else
            this.setId("inactive");
    }

    @Override
    public void action() {
        this.toggleActiveStatus();
        DonationCategoryButton.getInstance().setId("inactive");

        // TODO add functionality
    }
}

