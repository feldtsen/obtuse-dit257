package application.view.status;

import application.controller.ClientController;
import javafx.scene.control.Button;

public class LogoutButton extends Button {
    private static LogoutButton instance = null;

    private LogoutButton() {
        this.setId("logoutButton");

        this.setText("Log Out");

        this.setOnMouseClicked(e -> mouseClickAction());
    }

    public static LogoutButton getInstance() {
        if(instance == null) instance = new LogoutButton();
        return instance;
    }

    private void mouseClickAction() {
        ClientController.handleLogout();
    }
}
