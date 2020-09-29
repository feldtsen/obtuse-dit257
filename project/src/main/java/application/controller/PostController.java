package application.controller;

import application.model.board.Board;
import application.model.client.IClient;
import application.model.posts.Donation;
import application.model.posts.IPost;
import application.model.posts.Post;
import application.view.ResourceLoader;
import application.view.navigation.BoardNavigationButton;
import application.view.pages.EditPage;
import application.view.pages.PageParent;
import application.view.pages.PublishPage;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PostController {

    public static void createPost() {
        IClient client = ClientController.loadState();
        PublishPage publishPage = PublishPage.getInstance();

        Post newPost = new Donation(publishPage.getTitleInput().getText(), publishPage.getDescriptionInput().getText(), client.getUser(), null);

        client.getBoard().addPost(newPost);

        ClientController.saveState(client);
    }

   public static void editPost(MouseEvent e) {
        IClient client = ClientController.loadState();

        // Since we have multiple PostCards we need to make sure we retrieve the card relative to clicked button
        Button clickedButton = (Button) e.getSource();
        VBox currentPostCard = (VBox) clickedButton.getParent();
        Text currentPostUuid = (Text) currentPostCard.lookup("#id");

        // Retrieves the correct post based on the UUID
        IPost oldPost = client.getBoard().getSpecificPost(currentPostUuid.getText());

        // Populates the field in the edit page to reflect the current content of the post
        EditPage editPage = EditPage.getInstance();
        EditPage.setTitleText(oldPost.getTitle());
        EditPage.setDescriptionText(oldPost.getDescription());
        EditPage.setUuid(oldPost.getUUID());

        // Makes the edit page visible
        PageParent.loadPage(editPage);

    }

    public static void updatePost(){
        IClient client = ClientController.loadState();

        Post newPost = new Donation(EditPage.getTitleInput().getText(), EditPage.getDescriptionInput().getText(), client.getUser(), null, EditPage.getUuid());

        client.getBoard().replacePost(EditPage.getUuid(), newPost);

        ClientController.saveState(client);

        BoardNavigationButton.getInstance().action(null);

    }

}
