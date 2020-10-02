package application.controller;

import application.model.client.Client;
import application.model.client.IClient;
import application.model.posts.Donation;
import application.model.posts.IPost;
import application.model.posts.Post;
import application.view.navigation.BoardNavigationButton;
import application.view.pages.EditPage;
import application.view.pages.PageParent;
import application.view.pages.PublishPage;

import java.io.IOException;

public class PostController {

    public static void createPost() {
        IClient client = Client.getInstance();

        if(client.getUser() == null) {
            //TODO: alert?
            System.out.println("You cannot make a post unless you are logged in.");
            return;
        }

        // Referencing the publish page to retrieve input from the user
        PublishPage publishPage = PublishPage.getInstance();
        Post newPost = new Post(publishPage.getTitleInput(), publishPage.getDescriptionInput(), client.getUser(), null, publishPage.getPostType());

        // Adds the post to the board
        client.getBoard().addPost(newPost);

        // Save changes to persistent storage
        try {
            ClientController.saveToDisk();
        } catch (IOException e) {
            System.out.println("Failed to save client!");
        }
    }

   public static void editPost(String oldPostUUID) {
        //IClient client = ClientController.loadState();
       IClient client = Client.getInstance();

        // Retrieves the correct post based on the UUID
        IPost oldPost = client.getBoard().getSpecificPost(oldPostUUID);

        // Populates the field in the edit page to reflect the current content of the post
        EditPage.getInstance().prepareWithOldValues(oldPost);


        // Makes the edit page visible
        PageParent.loadPage(EditPage.getInstance());

    }

    public static void updatePost(){
        IClient client = Client.getInstance();

        // We do not modify the current post, we replace the old one with a new post
        Post newPost = new Donation(EditPage.getTitleInput(), EditPage.getDescriptionInput(), client.getUser(), null, EditPage.getUUID());
        client.getBoard().replacePost(EditPage.getUUID(), newPost);

        // Saves the changes to our persistent storage
        try {
            ClientController.saveToDisk();
        } catch (IOException e) {
            System.out.println("Failed to save client!");
        }

        //Simulating clicking the "board" button, loading the board page and refreshing all the post cards
        BoardNavigationButton.getInstance().action();
    }

    public static void deletePost(String postUUID) {
        IClient client = Client.getInstance();

        // Removes the specified post from the board
        client.getBoard().deletePost(postUUID);

        // Saves the changes to our persistent storage
        try {
            ClientController.saveToDisk();
        } catch (IOException e) {
            System.out.println("Failed to save client!");
        }

        //Simulating clicking the "board" button, loading the board page and refreshing all the post cards
        BoardNavigationButton.getInstance().action();
    }

}
