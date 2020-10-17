package application.view.pages.publish;


import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class RequestButton extends Button implements OnClickAction {
    private static RequestButton instance = null;

    private RequestButton() {
        this.setText("Request");
        this.setOnMouseClicked(this::action);
    }

    public static RequestButton getInstance() {
        if (instance == null) instance = new RequestButton();
        return instance;
    }

    @Override
    public void action(MouseEvent e) {
        this.getStyleClass().add("active");
        DonationButton.getInstance().getStyleClass().remove("active");
        PublishPage.getInstance().setPostType("Request");
    }
}
