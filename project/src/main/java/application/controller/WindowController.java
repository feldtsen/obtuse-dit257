package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.App;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.posts.Donation;
import application.model.posts.IPost;
import application.model.posts.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class WindowController implements Initializable {

    final static IClient client = Client.getTest();

    @FXML
    VBox content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void generatePost(ActionEvent e) {
        //The button being pressed
        Button publishSiteButton = (Button) e.getSource();
        // Need to get to the right level in the hierarchy
        VBox publishSiteContainer = (VBox) publishSiteButton.getParent().getParent();

        //Retrieves the content of the title input field
        String titleText = ((TextArea) publishSiteContainer.lookup("#titleInput")).getText();
        //Retrieves the content of the description field
        String descriptionText =((TextArea) publishSiteContainer.lookup("#descriptionInput")).getText();

        //Generates the new post and adds it to the board
        Post newPost = new Donation(titleText, descriptionText, client.getUser(), null);
        client.getBoard().addPost(newPost);
    }

    @FXML
    private void handlePublishButton() throws IOException {
        //loads the specified page
        VBox root = FXMLLoader.load(App.class.getResource("publishSite.fxml"));
        //adds margin of the site loaded
        VBox.setMargin(root, new Insets(20, 0, 0, 0));
        //removes current page and updates with the requested site
        content.getChildren().setAll(root);
    }

    @FXML
    private void handleBoardButton() {
        PostGenerator postGenerator = new PostGenerator(content);

        List<IPost> posts = client.getBoard().getAllPosts();

        for (IPost post : posts) {
            postGenerator.createDonation(post);
        }
    }

}
