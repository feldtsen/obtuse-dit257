package application.controller;

import application.model.client.IClient;
import application.model.posts.IPost;
import application.view.posts.PostCard;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.Collection;
import java.util.List;

public class BoardController {
    public static void retrievePosts() {
        IClient client = ClientController.loadState();
        if( client != null ) {
            Collection<IPost> posts = client.getBoard().getAllPosts();

            for (IPost post : posts) {
                new PostCard(post);
            }
        }
    }

    public static void claimButtonHandler(String postUUID) {
        IPost post = ClientController.loadState().getBoard().getSpecificPost(postUUID);
        System.out.println(post.getTitle());
    }
}
