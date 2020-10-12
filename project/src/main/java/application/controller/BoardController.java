package application.controller;

import application.ResourceLoader;
import application.model.board.Board;
import application.model.board.IBoard;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.posts.IPost;
import application.model.util.FileIO;
import application.view.pages.board.BoardPage;
import application.view.pages.board.categories.CategoryButtonContainer;
import application.view.pages.board.posts.PostCard;
import application.view.pages.board.search.SearchModule;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.IOException;
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

        if (client.getBoard() == null)
            return;


        BoardPage boardPage = BoardPage.getInstance();
        Collection<IPost> posts = client.getBoard().getAllPosts();
        PostCard postCard;
        int counter = 0;
        int rowIndex = 0;
        int colIndex = 0;
        for (IPost post : posts) {
            // Restricts it to 2 columns


            if (rowIndex == 0) {
                SearchModule searchModule = new SearchModule();
                boardPage.setFullWidth(searchModule);
                boardPage.add(searchModule, colIndex, rowIndex);
                rowIndex++;
            }

            if (rowIndex == 1) {
                CategoryButtonContainer categoryButtonContainer = CategoryButtonContainer.getInstance();
                boardPage.setFullWidth(categoryButtonContainer);
                boardPage.add(categoryButtonContainer, colIndex, rowIndex);
                rowIndex++;
            }


            colIndex = (counter % 2);
            postCard = new PostCard(post);

            // If there is only one card on a row, it will take occupy 100% of the width
            if (posts.size() - 1 == counter && colIndex == 0) boardPage.setFullWidth(postCard);


            //Appends the post to the board (grid pane) which need to know which cell to put it in
            boardPage.add(postCard, colIndex, rowIndex);

            // Everytime we filled a cell in the second column, we start on a new row
            if(colIndex == 1) rowIndex++;
            counter++;
        }

    }

    public static IBoard loadBoard() {
        // If a stored board already exists
        if (new File(ResourceLoader.boardFile).exists()) {
            // Return the stored board
            return (IBoard)FileIO.loadObject(ResourceLoader.boardFile);
        } else {
            // Otherwise, store a new, empty board and return
            return new Board();
        }
    }

    public static void saveBoardToDisk() throws IOException {
        FileIO.saveObject(Client.getInstance().getBoard(), ResourceLoader.boardFile);
    }
}
