package application.view.pages.publish;


import application.controller.ImageChooser;
import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;

public class DonationButton extends Button implements OnClickAction {
    private static DonationButton instance = null;

    private DonationButton() {
        this.setText("Donation");
        this.setOnMouseClicked(e -> this.action());

        this.setId("active");
    }

    public static DonationButton getInstance() {
        if (instance == null) instance = new DonationButton();
        return instance;
    }

    @Override
    public void action() {
        this.setId("active");
        RequestButton.getInstance().setId("inactive");
        PublishPage.getInstance().setPostType("Donation");
    }
}
