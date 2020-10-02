package application.view.pages.posttype;


import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;

public class DonationButton extends Button implements OnClickAction {
    private static DonationButton instance = null;

    private DonationButton() {
        this.setText("Donation");
        this.setOnMouseClicked(e -> this.action());
        this.setId("donationButton");
    }

    public static DonationButton getInstance() {
        if (instance == null) instance = new DonationButton();
        return instance;
    }

    @Override
    public void action() {
        System.out.println("button clicked");
    }
}
