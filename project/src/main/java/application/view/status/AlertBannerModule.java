package application.view.status;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AlertBannerModule extends HBox {
    private static AlertBannerModule instance = null;
    private static int alertIndex = 0;

    private static final int DURATION_IN_MILLISECONDS = 5000;

    private AlertBannerModule() {
        this.setId("alertBanner");
        HBox.setHgrow(this, Priority.ALWAYS);


        this.setAlignment(Pos.CENTER_RIGHT);
    }

    public static AlertBannerModule getInstance() {
        if(instance == null)
            instance = new AlertBannerModule();
        return instance;
    }

    public void setAlertMessage(String alertMessage, Alert.AlertType alertType) {
        alertIndex++;
        Label alertMessageLabel = new Label(" (" + alertIndex + ") " + alertMessage);

        if (alertType == Alert.AlertType.ERROR)alertMessageLabel.setStyle("-fx-text-fill: #CC5050");
        else if (alertType == Alert.AlertType.INFORMATION)alertMessageLabel.setStyle("-fx-text-fill: #5050CC");
        else alertMessageLabel.setStyle("-fx-text-fill: #50CC50!important;");

        this.getChildren().setAll(alertMessageLabel);

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(DURATION_IN_MILLISECONDS);
                alertIndex--;
                Platform.runLater(() -> AlertBannerModule.getInstance().getChildren().remove(alertMessageLabel));
            } catch (InterruptedException ignored) {
            }
        });
        thread.start();
    }
}
