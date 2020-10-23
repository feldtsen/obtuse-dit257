package application.view.pages.publish;


import javafx.scene.control.Button;

// Button for indicating that a  post is a Donation
public class DonationButton extends Button  {
    public DonationButton() {
        // Set text and style
        this.setText("Donation");
        this.getStyleClass().add("active");
    }


}