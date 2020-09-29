package application.controller;

import application.model.client.IClient;
import application.model.posts.Donation;
import application.model.posts.Post;
import application.view.pages.PublishPage;

public class PostController {

    public static void createPost() {
        IClient client = ClientController.loadClient();
        PublishPage publishPage = PublishPage.getInstance();
        Post newPost = new Donation(publishPage.getTitleInput().getText(), publishPage.getDescriptionInput().getText(), client.getUser(), null);
        client.getBoard().addPost(newPost);
        ClientController.saveClient(client, "clientFile.txt");
    }

    public static void editPost() {
        // TODO implement this
    }

}
