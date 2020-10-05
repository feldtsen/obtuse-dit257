package application.view.pages.login;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public abstract class LoginStatus extends HBox {

    private Label loginText;
    private Label loginStatus;  //label that shows what user is currently logged in

    private LoginStatus() {
        loginText = new Label("Logged in as: ");
        loginStatus = new Label("None");
        this.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(loginText, loginStatus);
    }

    /**
     * Set the passed in user as the currently logged in user
     * @param userName the user name
     */
    public void setLoggedInAs(String userName) {
        loginStatus.setText(userName);
    }
}
