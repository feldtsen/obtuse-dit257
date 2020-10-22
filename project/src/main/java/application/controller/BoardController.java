package application.controller;

import application.ResourceLoader;
import application.model.board.Board;
import application.model.board.IBoard;
import application.model.board.IFilter;
import application.model.client.Client;
import application.model.client.IClient;
import application.model.posts.IPost;
import application.model.util.FileIO;
import application.view.pages.board.BoardPage;
import application.view.pages.board.filter.FilterBanner;
import application.view.pages.board.posts.PostCard;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

// This class is responsible for setting up the board and load/save of the board.
public class BoardController {

    // Sets the filter for client and refreshes board
    public static void setFilter(IFilter filter) {
        Client.getInstance().getBoard().setFilter(filter);
        BoardPage.getInstance().getChildren().setAll();
        retrievePosts();
    }

    // Sets up the board with posts if user is logged in.
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
        boardPage.getChildren().setAll();
        Collection<IPost> posts = client.getBoard().getVisiblePosts();
        int counter = 0;
        int rowIndex = 0;
        int colIndex = 0;


        FilterBanner filterBanner = FilterBanner.getInstance();

        
        if (!boardPage.getChildren().contains(filterBanner)) {
            boardPage.setFullWidth(filterBanner);
            boardPage.add(filterBanner, colIndex, rowIndex);
        }

        rowIndex++;

        if (posts.isEmpty()) {
            ClientController.showAlert("The board is empty", Alert.AlertType.INFORMATION);
        }

        Collection<PostCard> postCards = BoardController.convertToPostcardCollection(posts);
        BoardController.addPosts(postCards, counter, rowIndex, colIndex);

    }

    private static Collection<PostCard> convertToPostcardCollection (Collection<IPost> posts) {
        Collection<PostCard> postCards = new ArrayList<>();
        for (IPost post : posts) {
           postCards.add(new PostCard(post));
        }

        // This will fill the empty columns so that the width of the GridPane always stays the same without hardcoding
        // a value for the width
        int emptyColumns = 3 - (posts.size() % 3);
        for (int i = 0; i < emptyColumns; i++) {
           postCards.add(new PostCard());
        }

        return postCards;
    }

    private static void addPosts (Collection<PostCard> postsCards, int counter, int rowIndex, int colIndex) {
        BoardPage boardPage = BoardPage.getInstance();
        for (PostCard postCard : postsCards) {
            // Restricts it to 2 columns
            colIndex = (counter % 3);

            //Appends the post to the board (grid pane) which need to know which cell to put it in
            boardPage.add(postCard, colIndex, rowIndex);

            // Everytime we filled a cell in the second column, we start on a new row
            if(colIndex == 2) rowIndex++;
            counter++;
        }
    }

    // Loads the board if there is one, otherwise creates a new one
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

    // Saves Board object to disk
    public static void saveBoardToDisk() throws IOException {
        FileIO.saveObject(Client.getInstance().getBoard(), ResourceLoader.boardFile);
    }
}
