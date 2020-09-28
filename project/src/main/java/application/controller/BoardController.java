package application.controller;

import application.model.client.IClient;
import application.model.posts.IPost;
import application.view.pages.posts.PostCard;

import java.util.List;

public class BoardController {
    public static void retrievePosts() {
        IClient client = ClientController.loadClient();
        if( client != null ) {
            PostCard postCard = new PostCard();
            List<IPost> posts = client.getBoard().getAllPosts();

            for (IPost post : posts) {
                new PostCard().createDonation(post);
            }
        }
    }
}
