package application.controller;

import application.model.board.Board;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.posts.IPost;
import application.model.posts.Post;
import application.view.pages.board.BoardPage;
import application.view.pages.board.posts.PostCard;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.VBox;

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
            // Restricts it to 2 columns
            colIndex = (counter % 2);

            PostCard postCard = new PostCard(post);

            // If there is only one card on a row, it will take occupy 100% of the width
            if (posts.size() - 1 == counter && colIndex == 0) BoardPage.getInstance().setFullWidth(postCard);

            //Appends the post to the board
            BoardPage.getInstance().add(postCard, colIndex, rowIndex);


            // Everytime we filled a cell in the second column, we start on a new row
            if(colIndex == 1) rowIndex++;
            counter++;
        }

    }

}
