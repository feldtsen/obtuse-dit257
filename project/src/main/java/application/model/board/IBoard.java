package application.model.board;

import application.model.posts.IPost;

import java.util.List;

public interface IBoard {
    List<IPost> getVisiblePosts();
    List<IPost> getAllPosts();
    void addPost(IPost post);
    boolean deletePost(IPost post);
    //void setFilter(IFilter);
}
