package application.view.pages.login;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class LoginStatusBoard extends HBox {

    private static LoginStatusBoard instance = null;
    private final Label loginText;
    private Label loginStatus;  //label that shows what user is currently logged in

    private LoginStatusBoard() {
        loginText = new Label("Logged in as: ");
        loginStatus = new Label("None");
        this.getChildren().addAll(loginText, loginStatus);
    }

    public static LoginStatusBoard getInstance() {
        if(instance == null)
            instance = new LoginStatusBoard();
        return instance;
    }

    /**
     * Set the passed in user as the currently logged in user
     * @param userName the user name
     */
    public void setLoggedInAs(String userName) {
        loginStatus.setText(userName);
    }
}
