package application.model.board;

import application.model.posts.IPost;

import java.util.ArrayList;
import java.util.List;

public class Board implements IBoard {

    List<IPost> posts;

    public Board() {
        this.posts = new ArrayList<>();
    }
    @Override
    public List<IPost> getVisiblePosts() {
        return posts;
    }

    @Override
    public void addPost(IPost new_post) {
        posts.add(new_post);
    }
}
