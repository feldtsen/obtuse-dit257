package application.view.status;

import application.controller.ClientController;
import javafx.scene.control.Button;

public class LogoutButton extends Button {
    private static LogoutButton instance = null;

    private LogoutButton() {
        // Adds a styling class to the logout button
        this.getStyleClass().add("logoutButton");

        // When clicked, decide what should happen
        this.setOnMouseClicked(e -> mouseClickAction());
    }

    // Singleton
    public static LogoutButton getInstance() {
        if(instance == null) instance = new LogoutButton();
        return instance;
    }

    // Asks the client controller to log out the user
    private void mouseClickAction() {
        ClientController.handleLogout();
    }

    // Hides and shows relevant text based on the state of the application
    public void setWhenLoggedOutText() {
        this.setText("");
    }
    public void setWhenLoggedInText(){
        this.setText(" (log out) ");
    }
}
