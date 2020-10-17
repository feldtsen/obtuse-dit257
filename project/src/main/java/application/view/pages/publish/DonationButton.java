package application.view.pages.publish;


import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class DonationButton extends Button implements OnClickAction {
    private static DonationButton instance = null;

    private DonationButton() {
        this.setText("Donation");
        this.setOnMouseClicked(this::action);

        this.getStyleClass().add("active");
    }

    public static DonationButton getInstance() {
        if (instance == null) instance = new DonationButton();
        return instance;
    }

    @Override
    public void action(MouseEvent e) {
        this.getStyleClass().add("active");
        RequestButton.getInstance().getStyleClass().remove("active");
        PublishPage.getInstance().setPostType("Donation");
    }
}
