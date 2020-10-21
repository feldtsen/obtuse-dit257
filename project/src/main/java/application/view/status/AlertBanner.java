package application.view.status;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

// Popup alert displayed to the user
public class AlertBanner extends Group {
    private static AlertBanner instance = null;
    // How long the alert message will be visible
    private static final int DURATION_IN_MILLISECONDS = 5000;

    private AlertBanner() {
        // If this is set on all components in a HBox, it will split the space evenly

        this.getStyleClass().add("alertBanner");
    }

    // Singleton
    public static AlertBanner getInstance() {
        if(instance == null)
            instance = new AlertBanner();
        return instance;
    }

    // Decides what to display
    public void setAlertMessage(String alertMessage, Alert.AlertType alertType) {
        Label label = new Label();
        label.setText("    " + alertMessage + "     ");

        // To make sure the message gets the correct color associated with what type of alert it is, we clear the style
        // then reapply
        label.getStyleClass().clear();
        label.getStyleClass().add("alertBanner");

        // The container for the message gets added
        this.getChildren().setAll(label);

        // We gibe the message different colors based on what type of alert it is
        if (alertType == Alert.AlertType.ERROR)            label.getStyleClass().add("error");
        else if (alertType == Alert.AlertType.CONFIRMATION)label.getStyleClass().add("confirmation");

        // We start a new thread so that the app doesn't freeze while a message is being displayed
        new Thread(() -> {
            try {
                // We wait for given time before removing the message
                Thread.sleep(DURATION_IN_MILLISECONDS);
                // Since we use setAll previously, only the last message gets removed by us. The rest will get
                // picked up by the garbage collector
                Platform.runLater(() -> this.getChildren().remove(label));
            } catch (InterruptedException ignored) {
            }
        }).start();
    }
}
