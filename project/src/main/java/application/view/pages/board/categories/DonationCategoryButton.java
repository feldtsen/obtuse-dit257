package application.view.pages.board.categories;

import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;

public class DonationCategoryButton extends Button implements OnClickAction {
    private static DonationCategoryButton instance = null;

    private DonationCategoryButton() {
        this.setText("Donations");
        this.setOnMouseClicked(e -> this.action());
        this.setId("inactive");
    }

    public static DonationCategoryButton getInstance() {
        if (instance == null) instance = new DonationCategoryButton();
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
        RequestCategoryButton.getInstance().setId("inactive");

        // TODO add functionality
    }
}
