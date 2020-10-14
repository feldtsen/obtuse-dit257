package application.model.board;

import application.model.posts.IPost;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface IBoard extends Serializable {
    List<IPost> getVisiblePosts();
    List<IPost> getAllPosts();

    IPost getSpecificPost(String id);

    void addPost(IPost post);

    void replacePost(String id, IPost newPost);

    boolean deletePost(String id);
    void setFilter(IFilter filter);
    IFilter getFilter();
}
