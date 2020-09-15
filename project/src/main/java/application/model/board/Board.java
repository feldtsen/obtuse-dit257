package application.model.board;

import application.model.posts.IPost;

import java.util.ArrayList;
import java.util.List;

public class Board implements IBoard {

    List<IPost> posts = new ArrayList<>();

    public Board(List<IPost> posts) {
        this.posts = posts;
    }
    @Override
    public List<IPost> getVisiblePosts() {
        return posts;
    }
}
