package application.view.pages.publish;


import javafx.scene.control.Button;

public class RequestButton extends Button {
    private static RequestButton instance = null;

    public RequestButton() {
        this.setText("Request");
    }

    public static RequestButton getInstance() {
        if (instance == null) instance = new RequestButton();
        return instance;
    }


}
