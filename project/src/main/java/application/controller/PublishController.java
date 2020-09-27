package application.controller;

import application.App;
import application.model.client.IClient;
import application.model.posts.Donation;
import application.model.posts.Post;
import application.view.pages.PageParent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PublishController {
    public static void generatePost(MouseEvent e) {
        IClient client = RegisterController.loadClient();
        //The button being pressed
        Button publishSiteButton = (Button) e.getSource();
        // Need to get to the right level in the hierarchy
        VBox publishSiteContainer = (VBox) publishSiteButton.getParent().getParent();

        //Retrieves the content of the title input field`
        String titleText = ((TextArea) publishSiteContainer.lookup("#titleInput")).getText();
        //Retrieves the content of the description field
        String descriptionText =((TextArea) publishSiteContainer.lookup("#descriptionInput")).getText();

        //Generates the new post and adds it to the board
        Post newPost = new Donation(titleText, descriptionText, client.getUser(), null);
        client.getBoard().addPost(newPost);
        RegisterController.saveClient(client, "clientFile.txt");
    }

    public static void handlePublishButton() {
        //loads the specified page
        VBox root = null;
        try {
            root = FXMLLoader.load(App.class.getResource("publishSite.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //adds margin of the site loaded
        VBox.setMargin(root, new Insets(20, 0, 0, 0));
        //removes current page and updates with the requested site
        PageParent.loadPage(root);
    }

}
