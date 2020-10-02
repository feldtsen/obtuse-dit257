package application.view.pages.posttype;


import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;

public class RequestButton extends Button implements OnClickAction {
    private static RequestButton instance = null;

    private RequestButton() {
        this.setText("Request");
        this.setOnMouseClicked(e -> this.action());
        this.setId("requestButton");
    }

    public static RequestButton getInstance() {
        if (instance == null) instance = new RequestButton();
        return instance;
    }

    @Override
    public void action() {
        System.out.println("button clicked");
    }
}
