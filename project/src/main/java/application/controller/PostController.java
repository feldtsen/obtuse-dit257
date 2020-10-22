package application.controller;

import application.model.client.Client;
import application.model.client.IClient;
import application.model.posts.IPost;
import application.model.posts.Post;
import application.view.navigation.PublishNavigationButton;
import application.view.pages.PageParent;
import application.view.pages.publish.EditPage;
import application.view.pages.publish.PublishPage;
import javafx.scene.control.Alert;

import java.io.IOException;

// Responsible for creating, editing and deleting posts. Used in view.
public class PostController {

    // CReads the contents from publish page and adds the post to board
    public static void createPost() {
        IClient client = Client.getInstance();

        if(client.getUser() == null) {
            ClientController.showAlert("You cannot make a post unless you are logged in", Alert.AlertType.INFORMATION);
            return;
        }

        // Referencing the publish page to retrieve input from the user
        PublishPage publishPage = PublishPage.getInstance();

        // Disallow publishing post with no title
        if(publishPage.getTitleInput().isBlank()) {
            ClientController.showAlert("A post must have a title", Alert.AlertType.ERROR);
            return;
        }
        // Disallow publishing a post with no description
        if(publishPage.getDescriptionInput().isBlank()) {
            ClientController.showAlert("A post must have a description", Alert.AlertType.ERROR);
            return;
        }

        IPost newPost = new Post(publishPage.getTitleInput(),
                publishPage.getDescriptionInput(),
                client.getUser(),
                publishPage.getPostType(),
                publishPage.getSelectedTags(),
                publishPage.getImagePath()
        );

        // Adds the post to the board
        client.getBoard().addPost(newPost);
        ClientController.showAlert("Successfully posted " + newPost.getTitle(), Alert.AlertType.CONFIRMATION);

        // Save changes to persistent storage
        try {
            ClientController.saveToDisk();
        } catch (IOException e) {
            System.out.println("Failed to save client!");
        }
    }

    // Used to create a new edited post based on a old post
   public static void editPost(String uniqueID) {
        //IClient client = ClientController.loadState();
       IClient client = Client.getInstance();

        // Retrieves the correct post based on the uniqueID
        IPost oldPost = client.getBoard().getSpecificPost(uniqueID);

        // Populates the field in the edit page to reflect the current content of the post
        EditPage.getInstance().prepareWithOldValues(oldPost);

        ClientController.showAlert("Currently editing " + oldPost.getTitle(), Alert.AlertType.INFORMATION);

        // Makes the edit page visible
        PageParent.loadPage(EditPage.getInstance(), PublishNavigationButton.getInstance());

    }

    // Used to override a post with an edited post
    public static void updatePost(){
        IClient client = Client.getInstance();
        EditPage editPage = EditPage.getInstance();

        // We do not modify the current post, we replace the old one with a new post
        IPost newPost = new Post(editPage.getTitleInput(), editPage.getDescriptionInput(), client.getUser(), editPage.getPostType(), editPage.getTags(), editPage.getImagePath());
        newPost.setUniqueID(editPage.getUniqueID());
        client.getBoard().replacePost(editPage.getUniqueID(), newPost);

        ClientController.showAlert("Successfully updated " + newPost.getTitle(), Alert.AlertType.CONFIRMATION);

        // Saves the changes to our persistent storage
        try {
            ClientController.saveToDisk();
        } catch (IOException e) {
            System.out.println("Failed to save client!");
        }

        //Simulating clicking the "board" button, loading the board page and refreshing all the post cards
        BoardController.retrievePosts();
    }

    // Deletes the post with the corresponding uniqueID
    public static void deletePost(String uniqueID) {
        IClient client = Client.getInstance();
        IPost oldPost = client.getBoard().getSpecificPost(uniqueID);

        // Removes the specified post from the board
        client.getBoard().deletePost(uniqueID);
        ClientController.showAlert("Successfully deleted " + oldPost.getTitle(), Alert.AlertType.CONFIRMATION);

        // Saves the changes to our persistent storage
        try {
            ClientController.saveToDisk();
        } catch (IOException e) {
            System.out.println("Failed to save client!");
        }

        //Simulating clicking the "board" button, loading the board page and refreshing all the post cards
        BoardController.retrievePosts();
    }

}
