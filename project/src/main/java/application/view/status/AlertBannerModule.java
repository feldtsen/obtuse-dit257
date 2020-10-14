package application.view.status;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AlertBannerModule extends HBox {
    private static AlertBannerModule instance = null;
    // How long the alert message will be visible
    private static final int DURATION_IN_MILLISECONDS = 5000;

    private AlertBannerModule() {
        // If this is set on all components in a HBox, it will split the space evenly
        HBox.setHgrow(this, Priority.ALWAYS);

        // The message will be shown to the far left of the given space
        this.setAlignment(Pos.CENTER_LEFT);
    }

    // Singleton
    public static AlertBannerModule getInstance() {
        if(instance == null)
            instance = new AlertBannerModule();
        return instance;
    }

    public void setAlertMessage(String alertMessage, Alert.AlertType alertType) {
        Label alertMessageLabel = new Label(alertMessage);


        // We gibe the message different colors based on what type of alert it is
        if (alertType == Alert.AlertType.ERROR)alertMessageLabel.setStyle("-fx-text-fill: #CC5050");
        else if (alertType == Alert.AlertType.INFORMATION)alertMessageLabel.setStyle("-fx-text-fill: #5050CC");
        else alertMessageLabel.setStyle("-fx-text-fill: #50CC50!important;");

        // We visually override the last message
        this.getChildren().setAll(alertMessageLabel);

        // We start a new thread so that the app doesn't freeze while a message is being displayed
        new Thread(() -> {
            try {
                // We wait for given time before removing the message
                Thread.sleep(DURATION_IN_MILLISECONDS);
                // Since we use setAll previously, only the last message gets removed by us. The rest will get
                // picked up by the garbage collector
                Platform.runLater(() -> this.getChildren().remove(alertMessageLabel));
            } catch (InterruptedException ignored) {
            }
        }).start();
    }
}
