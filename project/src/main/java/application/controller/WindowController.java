package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.App;
import application.model.board.Board;
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

    final static Board board = new Board();
    final static IClient client = Client.getTest();

    @FXML
    VBox content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void generatePost(ActionEvent e) {
        System.out.println("generatePost");
        Button publishSiteButton = (Button) e.getSource();
        VBox publishSiteContainer = (VBox) publishSiteButton.getParent().getParent();
        String titleText =((TextArea) publishSiteContainer.lookup("#titleInput")).getText();
        String descriptionText =((TextArea) publishSiteContainer.lookup("#descriptionInput")).getText();
        Post newPost = new Donation(titleText, descriptionText, null, null);
        board.addPost(newPost);
    }

    @FXML
    private void handlePublishButton() throws IOException {
        VBox root = FXMLLoader.load(App.class.getResource("publishSite.fxml"));
        VBox.setMargin(root, new Insets(20, 0, 0, 0));
        content.getChildren().setAll(root);
    }

    @FXML
    private void handleBoardButton() {
        System.out.println("Board");
        PostGenerator postGenerator = new PostGenerator(content);
        List<IPost> posts = board.getAllPosts();

        for (IPost post : posts) {
            postGenerator.createDonation(post.getTitle(),  post.getDescription());
        }
    }

    @FXML
    private void handleClaimButton(ActionEvent e) {
        Button button = (Button) e.getSource();
        Label title = (Label) button.getParent().lookup("#title");
        title.setText(button.getText() + " claimed!");
        button.setStyle("-fx-background-color: green");
        System.out.println("Claim button " + button.getText() + " pressed");
    }
}
