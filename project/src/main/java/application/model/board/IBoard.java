package application.model.board;

import application.model.posts.IPost;

import java.io.Serializable;
import java.util.List;

// Class representing all posts in the user client.
// The set of visible posts can be filtered using a filter
public interface IBoard extends Serializable {
    // Returns all posts that match the filter
    List<IPost> getVisiblePosts();

    // Returns all posts
    List<IPost> getAllPosts();

    // Fetches a specific post based on ID
    IPost getSpecificPost(String id);

    // Adds a post to the board
    void addPost(IPost post);

    // Replaces (or updates) a specific post
    void replacePost(String id, IPost newPost);

    // Deletes a post from the board
    boolean deletePost(String id);

    // Sets the filter. The filter will affect the result of calling getVisiblePosts.
    void setFilter(IFilter filter);

    IFilter getFilter();
}
