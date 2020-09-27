package application.controller;

import application.model.client.IClient;
import application.model.posts.IPost;
import application.view.PostGenerator;
import application.view.pages.BoardPage;

import java.util.List;

public class BoardController {
    public static void createBoard() {
        IClient client = RegisterController.loadClient();
        if( client != null ) {
            PostGenerator postGenerator = new PostGenerator(BoardPage.getInstance());
            List<IPost> posts = client.getBoard().getAllPosts();

            for (IPost post : posts) {
                postGenerator.createDonation(post);
            }
        }
    }
}
