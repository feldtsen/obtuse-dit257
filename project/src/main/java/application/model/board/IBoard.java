package application.model.board;

import application.model.posts.IPost;

import java.io.Serializable;
import java.util.List;

public interface IBoard extends Serializable {
    List<IPost> getVisiblePosts();
    List<IPost> getAllPosts();
    void addPost(IPost post);

    void replacePost(IPost newPost, IPost oldPost);

    boolean deletePost(IPost post);
    //void setFilter(IFilter);
}
