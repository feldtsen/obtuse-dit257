package application.view.pages.publish;


import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class DonationButton extends Button implements OnClickAction {
    private static DonationButton instance = null;

    private DonationButton() {
        this.setText("Donation");
        this.setOnMouseClicked(this::action);

        this.setId("active");
    }

    public static DonationButton getInstance() {
        if (instance == null) instance = new DonationButton();
        return instance;
    }

    @Override
    public void action(MouseEvent e) {
        this.setId("active");
        RequestButton.getInstance().setId("inactive");
        PublishPage.getInstance().setPostType("Donation");
    }
}
