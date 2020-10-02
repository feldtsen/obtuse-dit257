package application.view.pages.login;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class AlertBanner extends HBox {

    private static AlertBanner instance = null;
   private Label alertMessage;  //label that shows what user is currently logged in

    private AlertBanner() {
        alertMessage = new Label();

        this.setId("alertBanner");

        alertMessage.setStyle("-fx-text-fill: #50CC50!important;");

        this.setAlignment(Pos.CENTER_RIGHT);
    }

    public static AlertBanner getInstance() {
        if(instance == null)
            instance = new AlertBanner();
        return instance;
    }

    /**
     */
    public void setAlertMessage(String message) {
        alertMessage.setText(message);
        this.getChildren().setAll(alertMessage);

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                Platform.runLater(() -> AlertBanner.getInstance().getChildren().setAll());
            } catch (InterruptedException ignored) {
            }
        });
        thread.start();
    }
}
