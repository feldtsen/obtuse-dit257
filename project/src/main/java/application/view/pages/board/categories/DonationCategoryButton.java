package application.view.pages.board.categories;

import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;

public class DonationCategoryButton extends Button implements OnClickAction {
    private static DonationCategoryButton instance = null;

    private DonationCategoryButton() {
        this.setText("Donations");
        this.setOnMouseClicked(e -> this.action());
        this.setId("donationCategoryButton");
    }

    public static DonationCategoryButton getInstance(){
        if (instance == null) instance = new DonationCategoryButton();
        return instance;
    }

    @Override
    public void action() {
        // TODO add functionality
    }
}
