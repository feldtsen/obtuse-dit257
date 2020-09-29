package application.controller;

import application.model.client.IClient;
import application.model.posts.IPost;
import application.view.pages.posts.PostCard;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class BoardController {
    public static void retrievePosts() {
        IClient client = ClientController.loadState();
        if( client != null ) {
            List<IPost> posts = client.getBoard().getAllPosts();

            for (IPost post : posts) {
                new PostCard(post);
            }
        }
    }

    public static void claimButtonHandler(MouseEvent e) {
        System.out.println(((Label)((Button)e.getSource()).getParent().lookup("#title")).getText());
    }
}
