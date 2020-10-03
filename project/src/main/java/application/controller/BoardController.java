package application.controller;

import application.model.client.Client;
import application.model.client.IClient;
import application.model.posts.IPost;
import application.view.pages.board.BoardPage;
import application.view.pages.board.posts.PostCard;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;

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

        int counter = 0;
        int rowIndex = 0;
        int colIndex;
        for (IPost post : posts) {
            colIndex = (counter % 2);

            //Appends the post to the board
            BoardPage.getInstance().add(new PostCard(post), colIndex, rowIndex);

            if(colIndex == 1) rowIndex++;

            counter++;
        }
    }

    public static void claimButtonHandler(String postUUID) {
        IPost post = Client.getInstance().getBoard().getSpecificPost(postUUID);
        System.out.println(post.getTitle());
    }
}
