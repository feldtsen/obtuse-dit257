package application.view.pages.login;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class LoginStatusModule extends HBox {

    private static LoginStatusModule instance = null;
    private final Label loginText;
    private Label loginStatus;

    private LoginStatusModule() {
        loginText = new Label("Logged in as: ");
        loginStatus = new Label("User Name");
        this.getChildren().addAll(loginText, loginStatus);
    }

    public static LoginStatusModule getInstance() {
        if(instance == null)
            instance = new LoginStatusModule();
        return instance;
    }

    public String getLoginStatus() {
        return loginStatus.getText();
    }

    public void setLoginUser(String userName) {
        loginStatus.setText(userName);
    }
}
