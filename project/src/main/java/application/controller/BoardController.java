package application.controller;

import application.model.client.Client;
import application.model.client.IClient;
import application.model.posts.IPost;
import application.view.pages.board.BoardPage;
import application.view.pages.board.posts.PostCard;
import javafx.scene.control.Alert;

import java.util.Collection;

public class BoardController {
    public static void retrievePosts() {
        IClient client = Client.getInstance();

        if (client == null) {
            return;
        }

        if (client.getUser() == null) {
            ClientController.showAlert("You need to be logged in to view the board", Alert.AlertType.INFORMATION);
            return;
        }

        Collection<IPost> posts = client.getBoard().getAllPosts();

        for (IPost post : posts) {
            PostCard postCard = new PostCard(post);

            //Appends the post to the board
            BoardPage.getInstance().getChildren().add(postCard);
        }
    }

    public static void claimButtonHandler(String postUUID) {
        IPost post = Client.getInstance().getBoard().getSpecificPost(postUUID);
        System.out.println(post.getTitle());
    }
}
